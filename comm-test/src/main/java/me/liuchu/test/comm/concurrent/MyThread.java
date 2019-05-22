package me.liuchu.test.comm.concurrent;

public class MyThread extends Thread {

    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        System.out.println("执行了MyThread的run()方法");
    }
}
