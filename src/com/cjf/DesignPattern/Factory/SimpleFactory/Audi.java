package com.cjf.DesignPattern.Factory.SimpleFactory;

/**
 * @Descpription 简单工厂模式
 * @Author CJF
 * @Date 2018/12/18 11:16
 **/
public class Audi implements Car {
    @Override
    public void run() {
        System.out.println("奥迪车在跑");
    }
}
