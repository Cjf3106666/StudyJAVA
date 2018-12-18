package com.cjf.DesignPattern.Factory.SimpleFactory;

/**
 * @Descpription 简单工厂模式
 * @Author CJF
 * @Date 2018/12/18 11:19
 **/
public class Main {
    public static void main(String[] args) {

        Car car = new CarFactory().getCar("宝马");
        car.run();
    }
}
