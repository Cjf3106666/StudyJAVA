package com.cjf.demo;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class Demo21_ForkJoinPool {
    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();

    static {
        long start = System.currentTimeMillis();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        System.out.println(Arrays.stream(nums).sum());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {

    }

    static class AddTask extends RecursiveAction {
        int start, end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                System.out.println("from:" + start + " to:" + end + " = " + sum);
            } else {
                int middle = start + (end - start) / 2;
                AddTask task1 = new AddTask(start, middle);
                AddTask task2 = new AddTask(middle, end);
                task1.fork();
                task2.fork();
            }
        }
    }
}
