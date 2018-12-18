package com.cjf.DesignPattern.Proxy.DynamicProxy;

/**
 * @Descpription 动态代理
 * @Author CJF
 * @Date 2018/12/18 11:47
 **/
public class AmateurSinger implements Star {
    @Override
    public void sing() {
        System.out.println("业余歌手唱歌！");
    }
}
