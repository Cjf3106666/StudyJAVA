package com.cjf.剑指Offer;

/**
 * @Descpription
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 *
 * @Author CJF
 * @Date 2019/2/20 16:01
 **/
public class 二进制中的一个数 {

    public static void main(String[] args) {

        System.out.println(NumberOf2(5));
    }

   static int NumberOf2(int n) {
        int count = 0;
        while(n != 0){
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
