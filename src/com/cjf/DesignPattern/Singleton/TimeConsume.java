package com.cjf.DesignPattern.Singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Descpription 耗时测试
 * @Author CJF
 * @Date 2018/12/18 11:03
 **/
public class TimeConsume {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService main = Executors.newFixedThreadPool(5);

        //1
        main.execute(() -> {
            ExecutorService service = Executors.newFixedThreadPool(10);
            CountDownLatch countDownLatch = new CountDownLatch(10);
            Long begin = System.currentTimeMillis();
            for (int j = 0; j < 10; j++) {
                service.execute(() -> {
                    for (int i = 0; i < 1000000; i++) {
                        SingletonDemo1 s1 = SingletonDemo1.getSingleton();
                    }
                    countDownLatch.countDown();
                });
            }
            try {
                countDownLatch.await();
                System.out.println("饿汉式：" + (System.currentTimeMillis() - begin));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //2
        main.execute(() -> {
            ExecutorService service = Executors.newFixedThreadPool(10);
            CountDownLatch countDownLatch = new CountDownLatch(10);
            Long begin = System.currentTimeMillis();
            for (int j = 0; j < 1000000; j++) {
                service.execute(() -> {
                    for (int i = 0; i < 10; i++) {
                        SingletonDemo2 s2 = SingletonDemo2.getSingleton();
                    }
                    countDownLatch.countDown();
                });
            }
            try {
                countDownLatch.await();
                System.out.println("懒汉式：" + (System.currentTimeMillis() - begin));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //3
        main.execute(() -> {
            ExecutorService service = Executors.newFixedThreadPool(10);
            CountDownLatch countDownLatch = new CountDownLatch(10);
            Long begin = System.currentTimeMillis();
            for (int j = 0; j < 10; j++) {
                service.execute(() -> {
                    for (int i = 0; i < 1000000; i++) {
                        SingletonDemo3 s3 = SingletonDemo3.getSingleton();
                    }
                    countDownLatch.countDown();
                });
            }
            try {
                countDownLatch.await();
                System.out.println("双重检测锁：" + (System.currentTimeMillis() - begin));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //4
        main.execute(() -> {
            ExecutorService service = Executors.newFixedThreadPool(10);
            CountDownLatch countDownLatch = new CountDownLatch(10);
            Long begin = System.currentTimeMillis();
            for (int j = 0; j < 10; j++) {
                service.execute(() -> {
                    for (int i = 0; i < 1000000; i++) {
                        SingletonDemo4 s4 = SingletonDemo4.getSingletonDemo4();
                    }
                    countDownLatch.countDown();
                });
            }
            try {
                countDownLatch.await();
                System.out.println("枚举：" + (System.currentTimeMillis() - begin));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //5
        main.execute(() -> {
            ExecutorService service = Executors.newFixedThreadPool(10);
            CountDownLatch countDownLatch = new CountDownLatch(10);
            Long begin = System.currentTimeMillis();
            for (int j = 0; j < 10; j++) {
                service.execute(() -> {
                    for (int i = 0; i < 1000000; i++) {
                        SingletonDemo5 s5 = SingletonDemo5.getSingleton();
                    }
                    countDownLatch.countDown();
                });
            }
            try {
                countDownLatch.await();
                System.out.println("静态内部类：" + (System.currentTimeMillis() - begin));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
