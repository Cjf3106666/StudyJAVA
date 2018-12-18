package com.cjf.DesignPattern.Singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Descpription 破解单例的漏洞，无法破解枚举
 * 解决办法 在私有构造器中 抛出异常，
 * @Author CJF
 * @Date 2018/12/18 10:39
 **/
public class Crack {

    public static void main(String[] args) throws Exception {
        //通过反射破解
        //Test1();
        //通过反序列化破解
        Test2();
    }

    private static void Test2() throws IOException, ClassNotFoundException {
        SingletonDemo1 s1 = SingletonDemo1.getSingleton();
        FileOutputStream fos = new FileOutputStream("Serializable.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Serializable.txt"));
        SingletonDemo1 s2 = (SingletonDemo1) ois.readObject();
        System.out.println("s1==2 : " + (s1 == s2));
    }

    private static void Test1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz = Class.forName("com.cjf.DesignPattern.Singleton.SingletonDemo1");
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        SingletonDemo1 singletonDemo1 = SingletonDemo1.getSingleton();
        SingletonDemo1 singletonDemo2 = (SingletonDemo1) constructor.newInstance();
        System.out.println("singletonDemo1==singletonDemo2 : " + (singletonDemo1 == singletonDemo2));
    }


}
