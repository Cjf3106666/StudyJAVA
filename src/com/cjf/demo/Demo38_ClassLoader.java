package com.cjf.demo;

/**
 * @Descpription 类加载器
 * 双亲委派 保证核心库的类型安全，确保核心库都由父类加载
 * Tomcat不是双亲委派。子类优先
 *
 * @Author CJF
 * @Date 2019/1/2 11:53
 **/
public class Demo38_ClassLoader {
    public static void main(String[] args) {

        System.out.println("系统类加载器："+ClassLoader.getSystemClassLoader());

        System.out.println("扩展类加载器："+ ClassLoader.getSystemClassLoader().getParent());

        System.out.println("引导类加载器 无法获取："+ ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println(System.getProperty("java.class.path"));

        System.out.println("###################################");

    }


}
