package com.cjf.DesignPattern.Factory.AbstractFactory;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/18 11:27
 **/
public class BMWTyre implements Tyre {
    @Override
    public void display() {
        System.out.println("宝马轮胎");
    }
}
