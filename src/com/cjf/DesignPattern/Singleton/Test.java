package com.cjf.DesignPattern.Singleton;

/**
 * @Descpription 测试单例
 * @Author CJF
 * @Date 2018/12/18 10:30
 **/
public class Test {
    public static void main(String[] args) {
        SingletonDemo1 s11 = SingletonDemo1.getSingleton();
        SingletonDemo1 s12 = SingletonDemo1.getSingleton();
        System.out.println("饿汉式 - s11==s12 :" + (s11 == s12));

        SingletonDemo2 s21 = SingletonDemo2.getSingleton();
        SingletonDemo2 s22 = SingletonDemo2.getSingleton();
        System.out.println("懒汉式 - s21==s22 :" + (s21 == s22));

        SingletonDemo3 s31 = SingletonDemo3.getSingleton();
        SingletonDemo3 s32 = SingletonDemo3.getSingleton();
        System.out.println("双重检测锁 - s31==s32 :" + (s31 == s32));

        SingletonDemo4 s41 = SingletonDemo4.getSingletonDemo4();
        SingletonDemo4 s42 = SingletonDemo4.getSingletonDemo4();
        System.out.println("枚举 - s41==s42 :" + (s41 == s42));

        SingletonDemo5 s51 = SingletonDemo5.getSingleton();
        SingletonDemo5 s52 = SingletonDemo5.getSingleton();
        System.out.println("静态内部类 - s51==s52 :" + (s51 == s52));

    }


}
