package com.cjf.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

public class Demo5_Map_TimeConsume {
    static private Map<String, Object> map = new Hashtable();

    // static private Map<String,Object> map=new HashMap();
    // static private Map<String,Object> map=Collections.synchronizedMap(new HashMap<>());
    // static private Map<String,Object> map =new ConcurrentHashMap();
    // static private Map<String,Object> map =new ConcurrentSkipListMap<>();//跳表
    // static private Map<String,Object> map =new TreeMap<>();
    public static void main(String[] args) {
        Thread[] Threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(Threads.length);
        long start = System.currentTimeMillis();
        for (int i = 0; i < Threads.length; i++) {
            Threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    map.put(Thread.currentThread().getName() + Math.random() + j, j);
                }
                countDownLatch.countDown();
            }
            );
        }
        Arrays.asList(Threads).forEach(a -> a.start());
        try {
            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + " Map.Size:" + map.size());
    }
}
