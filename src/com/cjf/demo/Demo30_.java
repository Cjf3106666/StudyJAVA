package com.cjf.demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo30_ {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = new Demo30_().getClass().getClassLoader();
        BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("123.txt")));
        String temp;
        while ((temp = br.readLine()) != null) {
            System.out.println(temp);
        }

    }
}
