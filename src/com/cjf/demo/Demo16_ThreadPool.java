package com.cjf.demo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 固定个数的线程池
 */
public class Demo16_ThreadPool {
    static AtomicInteger k = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= new ThreadPoolExecutor(1,1,0L,TimeUnit.MILLISECONDS,new ArrayBlockingQueue(10));
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 30; i++) {
            service.execute(() -> {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 第" + k.getAndIncrement() + "个任务");
            });
        }
        System.out.println();
        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);


    }
}
