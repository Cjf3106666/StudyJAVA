package com.cjf.demo;

import java.util.concurrent.*;

public class Demo13_DelayQueue implements Delayed {
    private long runtime;
    static BlockingQueue<Demo13_DelayQueue> queue = new DelayQueue<>();

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(runtime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS) ? 1 : (this.getDelay(TimeUnit.MILLISECONDS) == o.getDelay(TimeUnit.MILLISECONDS) ? 0 : -1);
    }

    public Demo13_DelayQueue(long runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Demo13_DelayQueue{" +
                "runtime=" + runtime +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Demo13_DelayQueue task1 = new Demo13_DelayQueue(start + 500);
        Demo13_DelayQueue task2 = new Demo13_DelayQueue(start + 10000);
        Demo13_DelayQueue task3 = new Demo13_DelayQueue(start + 1500);
        Demo13_DelayQueue task4 = new Demo13_DelayQueue(start + 2500);
        Demo13_DelayQueue task5 = new Demo13_DelayQueue(start + 5300);
        Demo13_DelayQueue task6 = new Demo13_DelayQueue(start + 2000);
        queue.put(task1);
        queue.put(task2);
        queue.put(task3);
        queue.put(task4);
        queue.put(task5);
        queue.put(task6);
        System.out.println(queue);
        for (int i = 0; i < 6; i++) {
            System.out.println("第" + i + "个" + queue.take());
        }
        long end = System.currentTimeMillis();
        // Set set=Collections.synchronizedSet(new HashSet<>());
        System.out.println(end - start);

    }

}
