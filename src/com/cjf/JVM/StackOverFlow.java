package com.cjf.JVM;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Descpription 爆栈
 * @Author CJF
 * @Date 2018/12/18 15:47
 **/
public class StackOverFlow {
   volatile private static int count=0;

    static  public void  AddCount(){
        count++;
        AddCount();
    }

    public static void main(String[] args) throws InterruptedException {
        try{
            AddCount();
        }
        catch (Throwable e){
            e.printStackTrace();
    }
        System.out.println(count);

    }
}
