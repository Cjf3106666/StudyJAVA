package com.cjf.DesignPattern.Proxy.DynamicProxy;

/**
 * @Descpription 动态代理
 * @Author CJF
 * @Date 2018/12/18 11:50
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        Star star1=(Star)new DynamicProxy().bind(Class.forName("com.cjf.DesignPattern.Proxy.DynamicProxy.AmateurSinger").newInstance());
        Star star2=(Star)new DynamicProxy().bind(Class.forName("com.cjf.DesignPattern.Proxy.DynamicProxy.MajorSinger").newInstance());
        star1.sing();
        star2.sing();
    }
}
