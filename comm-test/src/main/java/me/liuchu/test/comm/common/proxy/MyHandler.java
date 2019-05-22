package me.liuchu.test.comm.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    private Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理类-开始");
        Object obj = method.invoke(target, args);
        System.out.println("执行代理类-结束");
        return obj;
    }
}
