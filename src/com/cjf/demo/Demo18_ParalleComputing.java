package com.cjf.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo18_ParalleComputing {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start1 = System.currentTimeMillis();
        List<Integer> results = getPrime(1, 200000);
        long end1 = System.currentTimeMillis();
        System.out.println("SingleThread:" + (end1 - start1) + " Result :" + results.size());

        ExecutorService service = Executors.newFixedThreadPool(5);
        MyTask task1 = new MyTask(1, 50000);
        MyTask task2 = new MyTask(50001, 100000);
        MyTask task3 = new MyTask(100001, 120000);
        MyTask task4 = new MyTask(120001, 140000);
        MyTask task5 = new MyTask(140001, 160000);
        MyTask task6 = new MyTask(160001, 170000);
        MyTask task7 = new MyTask(170001, 200000);
        Future f1 = service.submit(task1);
        Future f2 = service.submit(task2);
        Future f3 = service.submit(task3);
        Future f4 = service.submit(task4);
        Future f5 = service.submit(task5);
        Future f6 = service.submit(task6);
        Future f7 = service.submit(task7);
        start1 = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        f5.get();
        f6.get();
        f7.get();
        end1 = System.currentTimeMillis();
        System.out.println("ManyThread:" + (end1 - start1) + " Result :" + results.size());
    }

    static class MyTask implements Callable<List<Integer>> {
        int starPos, endPos;

        public MyTask(int starPos, int endPos) {
            this.starPos = starPos;
            this.endPos = endPos;
        }

        @Override
        public List<Integer> call() throws Exception {
            return getPrime(starPos, endPos);
        }


    }

    static private List<Integer> getPrime(int starPos, int endPos) {
        List<Integer> results = new ArrayList<>();
        for (int i = starPos; i < endPos; i++) {
            if (isPrime(i)) {
                results.add(i);
            }
        }
        return results;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
