package com.cjf.DesignPattern.Factory.FactoryMethod;

/**
 * @Descpription 工厂方法模式
 * @Author CJF
 * @Date 2018/12/18 11:22
 **/
public class BMWCarFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new BMW();
    }
}
