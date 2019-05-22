package me.liuchu.test.comm.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class TestSync {

    private static final Object obj = new Object();
    private static int unsafeSum = 0;
    private static int syncSum = 0;

    private static volatile AtomicInteger volatileSum = new AtomicInteger(0);

    private void unsafeIncrease(){

        for (int i = 0; i < 1000000; i++) {
            unsafeSum++;
        }

    }

    private void volatileIncrease(){

        for (int i = 0; i < 1000000; i++) {
            volatileSum.incrementAndGet();
        }

    }

    private void syncIncrease(){

        synchronized (obj){
            for (int i = 0; i < 1000000; i++) {
                syncSum++;
            }
        }

    }

    private int getSyncSum(){
        return TestSync.syncSum;
    }

    private int getUnsafeSum(){
        return TestSync.unsafeSum;
    }

    private int getVolatileSum(){
        return TestSync.volatileSum.get();
    }

    public static void main(String[] args) {

        TestSync sync = new TestSync();

        for (int i = 0; i < 10; i++) {
            ExecutorTool.EXECUTOR.execute(sync::syncIncrease);
        }

        try {
            Thread.sleep(2000);
            System.out.println("sync sum:"+sync.getSyncSum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            ExecutorTool.EXECUTOR.execute(sync::volatileIncrease);
        }

        try {
            Thread.sleep(2000);
            System.out.println("volatile sum:"+sync.getVolatileSum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            ExecutorTool.EXECUTOR.execute(sync::unsafeIncrease);
        }

        try {
            Thread.sleep(2000);
            System.out.println("unsafe sum:"+sync.getUnsafeSum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
