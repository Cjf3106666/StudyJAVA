package com.cjf.demo;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Demo4_ConcurrentLinkedQueue_tickets {
    static private Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票号：" + i);
        }
    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        String temp = tickets.poll();
                        if (temp != null) {
                            System.out.println(Thread.currentThread().getName() + "消费了" + temp);
                        } else {
                            break;
                        }

                    }
                }
            }).start();

        }
    }
}
