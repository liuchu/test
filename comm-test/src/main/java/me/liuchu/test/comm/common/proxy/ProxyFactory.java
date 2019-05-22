package me.liuchu.test.comm.common.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    private static MyHandler self;

    public static <M> M getProxy(M m) {
        return (M) Proxy.newProxyInstance(m.getClass().getClassLoader(),
                m.getClass().getInterfaces(), new MyHandler(m));
    }
}
