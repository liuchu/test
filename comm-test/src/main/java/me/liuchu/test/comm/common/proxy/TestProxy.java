package me.liuchu.test.comm.common.proxy;

public class TestProxy {

    private static void test(){
        InterfaceA proxyA = ProxyFactory.getProxy(new ObjectRealA());
        InterfaceB proxyB = ProxyFactory.getProxy(new ObjectRealB());

        proxyA.methodA();
        proxyB.methodB();
    }

    public static void main(String[] args) {
        test();
    }
}
