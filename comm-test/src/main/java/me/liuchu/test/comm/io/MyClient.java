package me.liuchu.test.comm.io;

import com.chuliu.demo.test.concurrent.ExecutorTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {

    public void startClient() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            ExecutorTool.EXECUTOR.submit(() -> {
                Socket socket = null;
                try {
                    socket = new Socket("localhost", 9999);
                    PrintWriter writer = new PrintWriter(socket.getOutputStream());

                    writer.write("你好" + finalI);

                    writer.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String res;

                    while ((res = reader.readLine()) != null) {
                        System.out.println("服务器的回应:" + res);
                    }

                } catch (IOException e) {
                    try {
                        socket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        new MyClient().startClient();
    }
}
