package com.cjf.demo;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo30_ {
   volatile static int a;
    public static void main(String[] args) {

        ExecutorService service=Executors.newFixedThreadPool(2);
        for (int k=0;k<5;k++) {
            service.execute(() -> {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(Thread.currentThread().getName()+" : "+a);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ExecutorService service1=Executors.newFixedThreadPool(5);
        for(int j=0;j<5;j++){
        service1.execute(()->{
            while(true) {
                try{
                    Thread.sleep(2000);
                    a++;
                    System.out.println(Thread.currentThread().getName()+" 加了一次");
                }catch (InterruptedException e){
                e.printStackTrace();

                }
            }
        });
    }}
}
