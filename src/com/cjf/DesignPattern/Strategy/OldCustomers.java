package com.cjf.DesignPattern.Strategy;

/**
 * @Descpription 策略模式
 * @Author CJF
 * @Date 2018/12/18 13:24
 **/
public class OldCustomers implements Calculator {

    @Override
    public double getPrice(double price) {
        System.out.println("老顾客打7折");
        return price*0.7;
    }
}
