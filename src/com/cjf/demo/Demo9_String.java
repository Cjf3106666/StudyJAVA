package com.cjf.demo;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.text.SimpleDateFormat;

public class Demo9_String {
    private int a = 10;

    public static void main(String[] args) {
        String b = "111";
        System.out.println(b);
        System.out.println(test(b));
        System.out.println(b);
    }

    static private String test(String t) {
        t = "1 0 0";
        return t;
    }
}
