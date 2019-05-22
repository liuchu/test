package me.liuchu.test.comm.concurrent;

public class TestWait {

    private static Object lock = new Object();

    private static void test(){
        synchronized (lock) {
            System.out.println("Start to wait");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Wait end");
        }
    }

    private static void no() {
        synchronized (lock) {
            System.out.println("Start to notify");
            lock.notify();
            try {
                Thread.sleep(2000);
                Thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notify end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(TestWait::test).start();

        Thread.sleep(10);
        lock = null;
        //new Thread(TestWait::no).start();

        //new Thread().join();
    }


}
