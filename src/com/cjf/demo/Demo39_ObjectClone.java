package com.cjf.demo;


import com.lenovo.autotest.tools.swipeTo;
import com.lenovo.autotest.tools.waitUntil;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/1/2 14:37
 **/

public class Demo39_ObjectClone implements Cloneable{
    String name ;
    Integer age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Demo39_ObjectClone(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo39_ObjectClone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Demo39_ObjectClone o=new Demo39_ObjectClone("zhangsan",new Integer(5));
        Demo39_ObjectClone o2= (Demo39_ObjectClone) o.clone();
        System.out.println(o);
        System.out.println(o2);
        System.out.println(o==o2);
        o2.age=new Integer(10);
        System.out.println(o);
        System.out.println(o2);
    }
}
