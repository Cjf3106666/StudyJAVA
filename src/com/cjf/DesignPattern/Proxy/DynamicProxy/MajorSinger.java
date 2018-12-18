package com.cjf.DesignPattern.Proxy.DynamicProxy;

/**
 * @Descpription 动态代理
 * @Author CJF
 * @Date 2018/12/18 11:48
 **/
public class MajorSinger implements Star{
    @Override
    public void sing() {
        System.out.println("职业歌手在唱歌！");
    }
}
