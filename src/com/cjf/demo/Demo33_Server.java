package com.cjf.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BIO SOCKET 编程 服务端
 */
public class Demo33_Server {

    static BlockingQueue<PrintWriter> pws = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(6666);
        ExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ExecutorService service2 = Executors.newCachedThreadPool();
        service.execute(() -> {
            while (true) {
                Socket socket = null;
                try {
                    socket = server.accept();
                    service2.execute(new ConnectThread(socket));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String temp = sc.nextLine();
            for (PrintWriter e : pws
                    ) {
                e.println(temp);
                e.flush();
            }
        }
        for (PrintWriter e : pws
                ) {
            e.close();
        }
    }

    static class ConnectThread implements Runnable {

        private Socket socket;

        public ConnectThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println(socket.getInetAddress() + ":" + socket.getPort() + " " + " 连接了服务器 ");
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                pws.put(pw);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

