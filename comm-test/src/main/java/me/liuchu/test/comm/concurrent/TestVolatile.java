package me.liuchu.test.comm.concurrent;

public class TestVolatile {

    private static int sum = 0;

    private static void test(){
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum  = sum + 5;
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum  = sum + 10;
        });

        t1.start();
        t2.start();

        while (true) {
            System.out.println(sum);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        test();
    }
}
