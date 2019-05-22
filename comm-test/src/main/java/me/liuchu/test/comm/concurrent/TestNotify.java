package me.liuchu.test.comm.concurrent;

/**
 * 验证一个Thread在运行结束之后是否会调用这个Thread本身的notifyAll方法
 *
 */
public class TestNotify {

    private static void test() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                System.out.println("子线程执行开始");
                Thread.sleep(5000);
                System.out.println("子线程执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        synchronized (t) {
            t.start();
        }

        synchronized (t) {
            System.out.println("wait 开始");
            t.wait();
            System.out.println("wait 结束，一定是有人notify了");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
