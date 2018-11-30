package com.cjf.demo;

import java.util.concurrent.*;

public class Demo17_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });
        new Thread(task).start();
        System.out.println(task.get());


        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });

        System.out.println(f.isDone());
        System.out.println(f.get());
        System.out.println(f.isDone());

    }
}
