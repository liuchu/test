package me.liuchu.test.comm.concurrent;

public class TestVisible {

    private static final Object lock = new Object();
    private static int sum = 0;

    private static void test(){

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (lock) {
                    sum = sum + 1;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        test();
        System.out.println("Sum: "+ sum);
    }
}
