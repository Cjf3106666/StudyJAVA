package com.cjf.DesignPattern.Strategy;

/**
 * @Descpription 策略模式
 * @Author CJF
 * @Date 2018/12/18 13:26
 **/
public class Main {
    public static void main(String[] args) {
        System.out.println(new NewCustomers().getPrice(18.5));
        System.out.println(new OldCustomers().getPrice(18.5));
    }
}
