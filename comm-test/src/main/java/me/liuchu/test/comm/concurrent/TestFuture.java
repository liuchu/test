package me.liuchu.test.comm.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestFuture {

    public static class Task implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("calling thread:"+Thread.currentThread().getId());
            return "Now is "+System.currentTimeMillis();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> results = new ArrayList<>();
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            results.add(es.submit(new Task()));
        }

        for (Future<String> future : results){
            System.out.println("Feature Result: "+future.get());
        }

        es.shutdown();

    }
}
