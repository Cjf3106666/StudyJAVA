package com.cjf.DesignPattern.Proxy.StaticProxy;

/**
 * @Descpription 代理类
 * @Author CJF
 * @Date 2018/12/18 11:42
 **/
public class StarProxy {
    private Star star;

    public StarProxy(Star star) {
        this.star = star;
    }
    public void sing(){
        System.out.println("助理办理手续~");
        star.sing();
    }
}
