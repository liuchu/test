package me.liuchu.test.comm.cache;

import com.chuliu.demo.test.concurrent.ExecutorTool;

public class TestCache {

    private static final Task task = new Task();

    public void test(){

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ExecutorTool.EXECUTOR.execute(() -> task.doSth(1001));
        }

    }

    public static void main(String[] args) {
        new TestCache().test();
    }
}
