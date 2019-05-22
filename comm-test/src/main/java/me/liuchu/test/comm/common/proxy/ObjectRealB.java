package me.liuchu.test.comm.common.proxy;

public class ObjectRealB implements InterfaceB {

    @Override
    public void methodB() {
        System.out.println("执行真正的方法B");
    }
}
