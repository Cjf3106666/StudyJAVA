package com.cjf.DesignPattern.Singleton;

/**
 * @Descpription 懒汉式
 * @Author CJF
 * @Date 2018/12/18 10:22
 **/
public class SingletonDemo2 {
    private static SingletonDemo2 singletonDemo;

    private SingletonDemo2() {
    }

    synchronized public static SingletonDemo2 getSingleton() {
        if (singletonDemo == null) {
            singletonDemo = new SingletonDemo2();
        }
        return singletonDemo;
    }

}
