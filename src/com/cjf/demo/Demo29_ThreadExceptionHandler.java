package com.cjf.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ExceptionThread implements Runnable{
    @Override
    public void run() {
        System.out.println("run by "+ Thread.currentThread());
        throw new RuntimeException("asadasda");
    }
}
class MyuncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught "+e);
    }
}

class ThreadHandler implements ThreadFactory
{
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+" create a new Thread");
        Thread t= new Thread(r);
        t.setUncaughtExceptionHandler(new MyuncaughtExceptionHandler());
        System.out.println("eh = "+t.getUncaughtExceptionHandler());

        return t;

    }
}
public class Demo29_ThreadExceptionHandler {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool(new ThreadHandler());
        service.execute(new ExceptionThread());
        service.shutdown();

    }
}