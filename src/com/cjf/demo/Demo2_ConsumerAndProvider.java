package com.cjf.demo;

import java.util.Arrays;
import java.util.LinkedList;

public class Demo2_ConsumerAndProvider {
    final static LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
    final static int MAX_SIZE = 10;
    static int conut = 10;

    synchronized public void provider() {

        while (list.size() == MAX_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(1);
        conut++;
        System.out.println(Thread.currentThread().getName() + "生产了一个产品,剩余产品如下");
        System.out.println(list);
        System.out.println("--------------------------------------------");
        this.notify();

    }

    synchronized public void consumer() {
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.removeFirst();
        conut--;
        System.out.println(Thread.currentThread().getName() + "消费了一个产品,剩余产品如下");
        System.out.println(list.size() == 0 ? "没有产品了" : list);
        System.out.println("--------------------------------------------");

        this.notifyAll();

    }

    public static void main(String[] args) {
        Demo2_ConsumerAndProvider test = new Demo2_ConsumerAndProvider();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        test.consumer();

                    }
                }
            }).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        test.provider();
                    }
                }
            }).start();
        }
    }

}
