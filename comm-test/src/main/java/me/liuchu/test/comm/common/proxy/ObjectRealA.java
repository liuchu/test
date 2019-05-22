package me.liuchu.test.comm.common.proxy;

public class ObjectRealA implements InterfaceA{


    @Override
    public void methodA() {
        System.out.println("执行真正的方法A");
    }
}
