package me.liuchu.test.comm.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class TestForkJoin {

    public static void main(String[] args) {

        int[] arrs = new int[]{
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
                25,
        };
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        SubTask task1 = new SubTask(arrs);

        try {
            System.out.println("Result:"+forkJoinPool.submit(task1).get());
            if (!task1.isCompletedAbnormally() ){
                throw new RuntimeException("Fork/Join错误", task1.getException());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
