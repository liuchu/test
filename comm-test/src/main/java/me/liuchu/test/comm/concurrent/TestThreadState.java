package me.liuchu.test.comm.concurrent;

public class TestThreadState {

    public static void test() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while(true) {
                try {
                    System.out.println("Thread one is running");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while(true) {
                try {
                    System.out.println("Thread two is running");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.wait();

        Thread.sleep(3000);

        t1.notify();

    }


    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
