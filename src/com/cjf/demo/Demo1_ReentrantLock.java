package com.cjf.demo;


import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1_ReentrantLock {
    static ReentrantLock a = new ReentrantLock(true);

    static private void test() {
        for (int i = 0; i < 10000; i++) {
            a.lock();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在执行！");
            a.unlock();
        }
    }

    public static void main(String[] args) {

         class test extends Thread {
            @Override
            public void run() {
                //  super.run();
                test();
            }
        }
        Thread a= new Thread(new test());
         a.start();
    }

}
