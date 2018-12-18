package com.cjf.DesignPattern.Factory.SimpleFactory;

/**
 * @Descpription 简单工厂模式
 * @Author CJF
 * @Date 2018/12/18 11:17
 **/
public class CarFactory {
    public Car getCar(String type) {
        if (type.equals("宝马")) {
            return new BMW();
        } else if (type.equals("奥迪")) {
            return new Audi();
        } else {
            return null;
        }
    }
}
