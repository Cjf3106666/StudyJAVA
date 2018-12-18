package com.cjf.DesignPattern.Factory.AbstractFactory;

/**
 * @Descpription
 * @Author CJF
 * @Date 2018/12/18 11:31
 **/
public class Main {
    public static void main(String[] args) {
        new AudiFactory().create();
        new BMWFactory().create();
    }
}
