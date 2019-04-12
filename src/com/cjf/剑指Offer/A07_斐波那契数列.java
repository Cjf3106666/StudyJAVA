package com.cjf.剑指Offer;

/**
 * @Descpription 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * <p>
 * n<=39
 * @Author CJF
 * @Date 2019/2/20 15:17
 **/
public class A07_斐波那契数列 {

   static public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);

    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(8));
    }
}
