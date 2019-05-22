package me.liuchu.test.comm.concurrent;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;
import org.apache.commons.lang3.time.DateUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class TestLock {

    private Lock lock = new ReentrantLock();
    Condition lockCondition = lock.newCondition();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private int sum = 0;

    private void reentrantLock() throws InterruptedException {

        for (int i = 0; i < 300; i++) {
            ExecutorTool.EXECUTOR.submit(() -> {
                lock.lock();
                try {
                    sum++;
                } finally {
                    lock.unlock();
                }
            });
        }

        ExecutorTool.EXECUTOR.shutdown();
        ExecutorTool.EXECUTOR.awaitTermination(100, TimeUnit.SECONDS);
    }

    private void await() throws InterruptedException {
        lock.lock();
        try {

            System.out.println("线程" + Thread.currentThread() + "开始await");
            lockCondition.await();

            System.out.println("线程" + Thread.currentThread() + "await结束");

            System.out.println("线程" + Thread.currentThread() + "开始awaitNanos, 时间为5秒");
            long restNanos = lockCondition.awaitNanos(1000 * 1000 * 5);
            System.out.println("线程" + Thread.currentThread() + "awaitNanos结束，剩余时间:" + restNanos + "纳秒");

        } finally {
            lock.unlock();
        }
    }

    private void signal() {
        lock.lock();

        try {
            System.out.println("线程" + Thread.currentThread() + "开始signalAll");
            lockCondition.signalAll();
            System.out.println("线程" + Thread.currentThread() + "结束signalAll");
        } finally {
            lock.unlock();
        }
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
        TestLock test = new TestLock();
        /*test.reentrantLock();
        System.out.println(test.getSum());*/
        new Thread(new FutureTask<>(() -> {
            test.await();
            return "success";
        })).start();

        Thread.sleep(2);

        new Thread(new FutureTask<>(() -> {
            test.signal();
            return "success";
        })).start();

        Thread.sleep(2);

        new Thread(new FutureTask<>(() -> {
            test.signal();
            return "success";
        })).start();

/*
        Mutex mutex = new Mutex();
        mutex.acquire();
        mutex.release();
*/


    }
}
