package com.cjf.DesignPattern.Singleton;

/**
 * @Descpription Double Check Lock
 * @Author CJF
 * @Date 2018/12/18 10:22
 **/
public class SingletonDemo3 {
    private static volatile SingletonDemo3 singletonDemo;

    private SingletonDemo3() {
    }

    public static SingletonDemo3 getSingleton() {
        if (singletonDemo == null) {

            synchronized (SingletonDemo3.class) {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo3();
                }
            }
        }
        return singletonDemo;
    }
}
