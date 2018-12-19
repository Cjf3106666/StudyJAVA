package com.cjf.DesignPattern.Strategy;

/**
 * @Descpription 策略模式
 * @Author CJF
 * @Date 2018/12/18 13:24
 **/
public class NewCustomers implements Calculator {

    @Override
    public  double getPrice(double price) {
        System.out.println("新用户打8折");
        return price*0.8;
    }
}
