package com.cjf.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo28_简繁转换工具 {

    public static void main(String[] args) throws IOException {
         //System.out.println(traditionalized("测试数据"));
         //System.out.println(Tosimplechar("測試數據"));
    }

    public static String simchar() {
        StringBuilder sb1 = new StringBuilder();
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("简体字符库"));
            String temp1;
            while ((temp1 = br1.readLine()) != null) {
                sb1.append(temp1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb1.toString();
    }

    public static String comchar() {
        StringBuilder sb1 = new StringBuilder();
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("繁体字符库"));
            String temp1;
            while ((temp1 = br1.readLine()) != null) {
                sb1.append(temp1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb1.toString();
    }

    public static String traditionalized(String cc) {
        String str = "";
        for (int i = 0; i < cc.length(); i++) {
            try {
                char c = cc.charAt(i);
                int x = simchar().indexOf(c);
                str += comchar().charAt(x);
            } catch (Exception e) {
                str += cc.charAt(i);
            }
        }
        return str;
    }

    public static String Tosimplechar(String cc) {
        String str = "";
        for (int i = 0; i < cc.length(); i++) {
            try {
                char c = cc.charAt(i);
                int x = comchar().indexOf(c);
                str += simchar().charAt(x);
            } catch (Exception e) {
                str += cc.charAt(i);
            }
        }
        return str;
    }
}
