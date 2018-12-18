package com.cjf.demo;

import java.util.concurrent.*;

public class Demo31_Sleep {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<Integer> task1 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 2;
        });
        System.out.println(executor.isTerminated());
        System.out.println(executor);
        System.out.println(task1.get());
        System.out.println(executor.isTerminated());
        System.out.println(executor);

    }


}
