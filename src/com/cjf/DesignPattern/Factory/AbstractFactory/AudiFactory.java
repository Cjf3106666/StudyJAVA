package com.cjf.DesignPattern.Factory.AbstractFactory;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/18 11:30
 **/
public class AudiFactory implements PartsFactory {
    @Override
    public void create() {
        new AudiTyre().display();
        new AudiSeat().display();
    }
}
