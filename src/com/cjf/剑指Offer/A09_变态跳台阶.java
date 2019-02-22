package com.cjf.剑指Offer;

/**
 * @Descpription 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *
 * f(1)+f(2)+f(3)...+f(n-1) = 2*f(n-1)
 *
 * @Author CJF
 * @Date 2019/2/20 15:43
 **/
public class A09_变态跳台阶 {

    static public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        else return 2 * JumpFloorII(target - 1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
}
