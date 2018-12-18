package com.cjf.DesignPattern.Proxy.StaticProxy;

/**
 * @Descpription 静态代理
 * @Author CJF
 * @Date 2018/12/18 11:44
 **/
public class Main {
    public static void main(String[] args) {
        StarProxy proxy= new StarProxy(new Star("张学友",28));
        proxy.sing();
    }
}
