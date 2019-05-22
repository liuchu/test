package me.liuchu.test.comm.concurrent;

public class TestSyncInterrupt {

    private final static Object obj = new Object();

    private static void doInterrupt(Thread thread) {
        thread.interrupt();
    }

    private static void test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    System.out.println("等待");
                    obj.wait();
                    System.out.println("等待完成");
                } catch (InterruptedException e) {
                    System.out.println("线程wait" + Thread.currentThread() + "中断");
                    e.printStackTrace();
                    System.out.println("catch中尽心额外的wait逻辑处理");
                    System.out.println("是否是中断状态:" + Thread.currentThread().isInterrupted());
                }

                System.out.println("是否是中断状态:" + Thread.currentThread().isInterrupted());
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 1000000; i++) {
                    //do nothing
                }
            }
        });

        Thread t3 = new Thread(() -> {

            System.out.println("是否是中断状态:" + Thread.currentThread().isInterrupted());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("线程sleep" + Thread.currentThread() + "中断");
                e.printStackTrace();
                System.out.println("catch中尽心额外的sleep逻辑处理");
            }

            System.out.println("是否是中断状态:" + Thread.currentThread().isInterrupted());

            //再次sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("线程再次sleep" + Thread.currentThread() + "中断");
                e.printStackTrace();
                System.out.println("重置中断状态的返回值:" + Thread.interrupted());
            }

            System.out.println("是否是中断状态:" + Thread.currentThread().isInterrupted());

        });

        t1.start();

        Thread.sleep(500);
        t1.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
