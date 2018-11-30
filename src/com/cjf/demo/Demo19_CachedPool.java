package com.cjf.demo;

import java.util.concurrent.*;

public class Demo19_CachedPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);

        Future f1 = service.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        Future f2 = service.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        Future f3 = service.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        Future f4 = service.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        System.out.println(f1.isDone());
        System.out.println(f2.isDone());
        System.out.println(service);
        f1.get();
        f2.get();
        System.out.println(f1.isDone());
        System.out.println(f2.isDone());
        System.out.println(service);
        TimeUnit.SECONDS.sleep(70);
        System.out.println(service);
        System.out.println(f1 + " " + f2 + "  " + f3 + " " + f4);


    }


}
