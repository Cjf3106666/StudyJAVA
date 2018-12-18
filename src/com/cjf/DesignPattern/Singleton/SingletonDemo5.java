package com.cjf.DesignPattern.Singleton;


import static com.cjf.DesignPattern.Singleton.SingletonDemo5.SingeletonDemoInner.singletonDemo;

/**
 * @Descpription 静态内部类
 * @Author CJF
 * @Date 2018/12/18 10:22
 **/
public class SingletonDemo5 {

    public static class SingeletonDemoInner {
        public static final SingletonDemo5 singletonDemo = new SingletonDemo5();
    }

    private SingletonDemo5() {
    }

    public static SingletonDemo5 getSingleton() {
        return singletonDemo;
    }
}
