package me.liuchu.test.comm.utils;

import com.chuliu.demo.test.exception.ReachJobLimitationException;

import java.io.IOException;

public interface MyHttpServerBase {

    //开启服务器
    void start() throws IOException, ReachJobLimitationException;

    //自定义端口
    void setPort(int port);

    //自定义资源路径
    void setResourcePath(String path);

    void setTimeOut(int timeOut);

    //关闭服务器
    void close();

}
