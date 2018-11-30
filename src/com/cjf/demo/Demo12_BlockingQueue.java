package com.cjf.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo12_BlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        BlockingQueue queue2 = new LinkedBlockingDeque();
        BlockingQueue<String> queue1 = new ArrayBlockingQueue(10);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    try {
                        queue2.put(Thread.currentThread().getName() + Math.random());
                        System.out.println(Thread.currentThread().getName() + "生产了一个产品");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    try {

                        System.out.println(Thread.currentThread().getName() + "消费了一个产品 " + queue2.take());
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ).start();
        }

        for (Thread t : threads
                ) {
            t.start();
        }

    }
}
