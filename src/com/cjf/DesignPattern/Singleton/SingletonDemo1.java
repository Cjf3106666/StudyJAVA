package com.cjf.DesignPattern.Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Descpription 饿汉式
 * @Author CJF
 * @Date 2018/12/18 10:22
 **/
public class SingletonDemo1 implements Serializable {
    private static SingletonDemo1 singletonDemo1;

    static {
        singletonDemo1 = new SingletonDemo1();
    }

    private SingletonDemo1() {
    }

    public static SingletonDemo1 getSingleton() {
        return singletonDemo1;
    }

    private Object readResolve() throws ObjectStreamException {
        return singletonDemo1;
    }
}
