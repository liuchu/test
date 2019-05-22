package me.liuchu.test.comm.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockInterrupt {

    private final ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void execRun(){
        lock.lock();

        try{
            System.out.println("获取到锁了");
            Thread.sleep(100*1000);
            System.out.println("任务执行完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void execAwait(){
        lock.lock();

        try{
            System.out.println("等待开始");
            condition.await();
        } catch (InterruptedException e) {
            System.out.println("await捕获了异常，中断状态:"+Thread.currentThread().isInterrupted());
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void execBlock(){
        try {
            lock.lockInterruptibly();

            try{
                System.out.println("获取到锁了");
            }finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println("block时被中断了，这是synchronized不具备的特性");
            e.printStackTrace();
        }
    }

    private static void test() throws InterruptedException {
        TestLockInterrupt obj = new TestLockInterrupt();

        Thread t1 = new Thread(obj::execRun);
        Thread t2 = new Thread(obj::execBlock);
        t1.start();
        Thread.sleep(500);
        t2.start();

        Thread.sleep(500);
        t2.interrupt();

    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }

}
