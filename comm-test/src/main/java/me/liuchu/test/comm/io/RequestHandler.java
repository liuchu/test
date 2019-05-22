package me.liuchu.test.comm.io;

import com.chuliu.demo.test.concurrent.ExecutorTool;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class RequestHandler {

    private static ThreadPoolExecutor pool = ExecutorTool.EXECUTOR;

    public static void handle(String message, SelectionKey key) {
        pool.submit(new Request(message, key));

    }

    private static class Request implements Callable<String> {

        private String msg;
        private SelectionKey key;

        private Request(String msg, SelectionKey key) {
            this.msg = msg;
            this.key = key;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(500);
            System.out.println("处理信息中：" + msg);
            Thread.sleep(500);

            ByteBuffer buffer = (ByteBuffer) key.attachment();

            buffer.put("SUCCESS".getBytes());

            key.interestOps(SelectionKey.OP_WRITE);

            return "SUCCESS";
        }
    }
}
