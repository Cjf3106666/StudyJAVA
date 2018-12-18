package com.cjf.DesignPattern.Proxy.StaticProxy;

/**
 * @Descpription 被代理类
 * @Author CJF
 * @Date 2018/12/18 11:41
 **/
public class Star {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Star(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void sing(){
        System.out.println(name+" :"+"自己在唱歌！");
    }
}
