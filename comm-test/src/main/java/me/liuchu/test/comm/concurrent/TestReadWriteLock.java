package me.liuchu.test.comm.concurrent;

import java.util.Stack;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

    //供多个线程同时读写的栈
    private Stack<Integer> stack = new Stack<>();

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();
    private Condition readCondition = readLock.newCondition();
    private Condition writeCondition = writeLock.newCondition();

    private void writeAnNum(Integer num) {
        writeLock.lock();

        try {
            stack.push(num);
            System.out.println("推入栈顶:" + num);
        } finally {
            writeLock.unlock();
        }
    }

    private void readStack() {
        readLock.lock();

        try {
            int res = stack.peek();
            System.out.println("栈顶元素为:" + res);
        } finally {
            readLock.unlock();
        }
    }

    private static void test() {
        TestReadWriteLock test = new TestReadWriteLock();

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            new Thread(new FutureTask<>(() -> {
                test.writeAnNum(finalI);
                return "success";
            })).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new FutureTask<>(() -> {
                test.readStack();
                return "success";
            })).start();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
