package me.liuchu.test.comm.utils;

import com.chuliu.demo.test.exception.PoolException;
import com.chuliu.demo.test.exception.PoolRuntimeException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbConnectionPool {

    private final Object LOCK = new Object();

    /**
     * url, username, schema, driver在用@DbConnectionFactory构建本类对象时，时必传参数
     */
    private String url;
    private String username;
    private String password;
    private String driver;

    /**
     * 本类内部维护的连接池属性
     */
    //初始线程池容量
    private int initPoolSize;
    //每次扩容增加的容量
    private int increasePoolSize;
    //最大的线程池容量
    private int maxPoolSize;
    //连接超时时间，毫秒
    private int connectTimeOut;

    //连接池内所有的连接
    private List<Connection> pooledConnections;

    //当前在被用的连接
    private List<Connection> busyConnections;

    //空闲的连接
    private List<Connection> freeConnections;

    private DbConnectionPool(String url, String username, String password, String driver) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
    }

    public static DbConnectionPool buildPool(String url,
                                      String username,
                                      String password,
                                      String jdbcDriver) throws SQLException, ClassNotFoundException {
        DbConnectionPool pool = new DbConnectionPool(url, username, password, jdbcDriver);
        pool.initPool();
        return pool;
    }

    //本demo中写死，更好的方案是从配置文件读取
    void initPool() throws ClassNotFoundException, SQLException {

        //该方法只应该在开始时被调用一次
        if (pooledConnections != null) {
            return;
        }

        //基本属性
        initPoolSize = 4;
        increasePoolSize = 3;
        maxPoolSize = 10;
        connectTimeOut = 10000;

        //连接
        pooledConnections = new ArrayList<>(initPoolSize);
        busyConnections = new ArrayList<>(initPoolSize);
        freeConnections = new ArrayList<>(initPoolSize);

        //加载驱动
        Class.forName(driver);

        //初始化连接
        for (int i = 0; i < initPoolSize; i++) {
            pooledConnections.add(DriverManager.getConnection(url, username, password));
        }
        freeConnections.addAll(pooledConnections);
    }

    /**
     * 获取数据库连接
     *
     * @return 连接实例
     */
    public Connection fetchConnection() throws SQLException, InterruptedException, PoolException {

        if (pooledConnections == null || busyConnections == null || freeConnections == null) {
            throw new PoolRuntimeException("The connection pool was not initialized correctly", new Throwable());
        }

        Connection conn;
        //未成功获取到连接时，每一秒重新尝试一次，直到超时
        long beginTimeMi = System.currentTimeMillis();
        do {
            synchronized (LOCK) {

                if (freeConnections.size() > 0) { //有空闲连接
                    conn = freeConnections.get(0);
                    freeConnections.remove(conn);
                    busyConnections.add(conn);
                } else { //无空闲连接

                    //池内连接未达最大容量
                    if (pooledConnections.size() < maxPoolSize) {

                        //增加容量
                        for (int i = 0; i < increasePoolSize; i++) {

                            if (pooledConnections.size() == maxPoolSize) {
                                break;
                            }

                            Connection tempConn = DriverManager.getConnection(url, username, password);
                            pooledConnections.add(tempConn);
                            freeConnections.add(tempConn);
                        }

                        //offer
                        conn = freeConnections.get(0);
                        freeConnections.remove(conn);
                        busyConnections.add(conn);
                    } else {
                        conn = null;
                    }

                }

            }

            Thread.sleep(1000);

        } while (conn == null && (System.currentTimeMillis() - beginTimeMi) < connectTimeOut);

        //无法返回有效的连接，就抛出运行时异常
        if (conn == null) {
            throw new PoolException("Failed to fetch connection, the pooled connection amount has reached max limitation", new Throwable());
        }

        return conn;
    }

    /**
     * 释放数据库连接，调用方使用完成后，必须手动调用该方法，否则连接池认为调用方一直在占用该连接
     */
    public void releaseConnection(Connection conn) throws SQLException {

        //保证连接被关闭
        if (!conn.isClosed()) {
            conn.close();
        }

        synchronized (LOCK) {

            //从池内移除
            if (pooledConnections.contains(conn)) {
                pooledConnections.remove(conn);
            }
            if (busyConnections.contains(conn)) {
                busyConnections.remove(conn);
            }

            //并保证连接池内的最小连接数
            if (pooledConnections.size() < initPoolSize) {
                for (int i = pooledConnections.size(); i < initPoolSize; i++) {
                    Connection tempConn = DriverManager.getConnection(url, username, password);
                    pooledConnections.add(tempConn);
                    freeConnections.add(tempConn);
                }
            }
        }
    }

    /**
     * 关闭连接池。
     * 有活跃连接时，无法关闭，抛出异常
     *
     * @throws SQLException Connection#close()异常
     * @throws PoolException 连接池异常
     */
    public void closePool() throws SQLException, PoolException {

        if (pooledConnections == null || pooledConnections.size() == 0) {
            return;
        }

        if (busyConnections.size() != 0) {
            throw new PoolException("Failed to close connection pool due to there are active connection(s) ", new Throwable());
        }

        //关闭所有连接
        for (Connection conn : freeConnections) {
            conn.close();
        }

        pooledConnections = null;
        busyConnections = null;
        freeConnections = null;
    }

    /**
     * 获取当前线程池的容量
     * @return 结果
     */
    public int getPoolSize(){

        if (pooledConnections == null || pooledConnections.size() == 0) {
            return 0;
        }

        return pooledConnections.size();
    }

}
