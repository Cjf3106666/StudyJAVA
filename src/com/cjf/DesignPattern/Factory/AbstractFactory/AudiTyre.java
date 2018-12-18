package com.cjf.DesignPattern.Factory.AbstractFactory;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/18 11:26
 **/
public class AudiTyre implements Tyre {
    @Override
    public void display() {
        System.out.println("奥迪轮胎");
    }
}
