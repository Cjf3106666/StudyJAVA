package com.cjf.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo35_Client {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                Socket socket = null;
                try {
                    socket = new Socket("127.0.0.1", 6666);
                    BufferedReader ir = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String temp = "";
                    while ((temp = ir.readLine()) != null) {
                        System.out.println(socket.getInetAddress()+":"+socket.getPort()+"发来消息:"+temp);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
