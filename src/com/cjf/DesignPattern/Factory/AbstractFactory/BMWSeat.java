package com.cjf.DesignPattern.Factory.AbstractFactory;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/18 11:26
 **/
public class BMWSeat implements Seat {
    @Override
    public void display() {
        System.out.println("宝马座椅");
    }
}
