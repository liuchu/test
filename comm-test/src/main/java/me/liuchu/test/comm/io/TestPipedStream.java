package me.liuchu.test.comm.io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class TestPipedStream {

    private static void test() throws IOException {

        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();

        writer.connect(reader);

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                writer.write("你好");
                writer.write("我是麦");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writer.write("你在哪？");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {

            try {

                while (true) {

                    char[] buffer = new char[1024];
                    int length;
                    if ((length = reader.read(buffer)) != -1) {
                        System.out.println("收到数据：" + new String(buffer, 0, length));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static void main(String[] args) throws IOException {
        test();
    }
}
