package me.liuchu.test.comm.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.LinkedList;
import java.util.concurrent.*;

public class ExecutorTool {

    public static ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            5,
            20,
            10L,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(),
            new ThreadFactoryBuilder()
                    .setNameFormat("credit-pool-%d")
                    .build(),
            new ThreadPoolExecutor.DiscardPolicy()
    );

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        EXECUTOR.execute(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("HAHA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        EXECUTOR.execute(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("EMMM");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Future<String> future = EXECUTOR.submit(() -> "Hi!");
        //EXECUTOR.execute();

        String str2 = EXECUTOR.submit(() -> "I'm Lee").get();

        String str1 = future.get();

        System.out.println(str1 + str2);

        System.out.println("Active count:" + EXECUTOR.getActiveCount());
        System.out.println("Task count:" + EXECUTOR.getTaskCount());

        EXECUTOR.shutdown();

        //Callable

        FutureTask<String> futureTaskCal = new FutureTask<>(() -> {
            return "Good";
        });
        FutureTask<String> futureTaskRun = new FutureTask<>(() -> {
            throw new RuntimeException("这是Future捕获的Runnale的异常");
        }, "Result");

        //RunnableFuture<String> a = new FutureTask<>();

        new Thread(futureTaskCal).start();
        new Thread(futureTaskRun).start();

        Thread.sleep(500);
        String sCal;
        try{
            sCal = futureTaskCal.get();
        }catch (Exception e) {
            e.printStackTrace();
            sCal = "EEEEE";
        }

        String sRun;
        try{
            sRun = futureTaskRun.get();
        }catch (Exception e) {
            e.printStackTrace();
            sRun = "FFFFF";
        }

        System.out.println("thread type:" + sCal + ", " + sRun);

        //ExecutorService;
        //Executors.
        //Runnable
        //EXECUTOR.
        LinkedList linkedList = new LinkedList();

    }

}