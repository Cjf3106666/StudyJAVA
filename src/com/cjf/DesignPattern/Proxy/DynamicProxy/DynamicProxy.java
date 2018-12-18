package com.cjf.DesignPattern.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Descpription 动态代理
 * @Author CJF
 * @Date 2018/12/18 11:48
 **/
public class DynamicProxy implements InvocationHandler {
    Object obj;
    public Object bind(Object obj){
        this.obj=obj;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("助理手续已经办理完成！");
        Object returnVal=method.invoke(obj,args);

        return returnVal;
    }
}
