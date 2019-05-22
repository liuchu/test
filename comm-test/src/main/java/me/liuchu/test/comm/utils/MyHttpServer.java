package me.liuchu.test.comm.utils;


import com.chuliu.demo.test.exception.ReachJobLimitationException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简易的Http服务器
 */
public class MyHttpServer implements MyHttpServerBase {

    //线程池对象
    private MyThreadPool threadPool = new MyThreadPool(10);

    //服务器端口
    private int port = 8080;

    //资源路径
    private String resourcePath;

    //请求超时时间
    private int timeOut;

    //是否keep-alive
    private boolean keepAlive;

    @Override
    public void start() throws IOException, ReachJobLimitationException {

        //开启Socket
        ServerSocket server = new ServerSocket(port);

        //接受客户端的请求
        Socket socket;
        while ((socket = server.accept()) != null) {
            socket.setKeepAlive(keepAlive);
            socket.setSoTimeout(timeOut);
            //线程池处理socket
            //请求的提交是异步的，但在socket关闭之前，socket的连接不会断开
            threadPool.execute(new HttpRequestHandler(socket));
        }
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void setResourcePath(String path) {
        this.resourcePath = resourcePath;
    }

    @Override
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    @Override
    public void close() {

    }

    //静态内部类，处理请求
    public class HttpRequestHandler implements Runnable {

        //SocketServer所接受的Socket
        private Socket socket;

        HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //handle
            if (socket != null) {

            }
        }
    }
}
