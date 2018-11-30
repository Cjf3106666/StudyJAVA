package com.cjf.demo;


public interface Demo8_JDK8_InterfaceImp {

    default void test() {
        System.out.println("12345");
    }

    static void test2() {
        System.out.println("test");
    }

}
