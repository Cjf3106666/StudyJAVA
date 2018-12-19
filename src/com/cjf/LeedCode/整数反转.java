package com.cjf.LeedCode;

import java.util.*;

/**
 * @Descpription 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Author CJF
 * @Date 2018/12/19 12:48
 * <p>
 * 我的解法：
 **/
public class 整数反转 {

    public static void main(String[] args) {
        int a = -123;
        System.out.println(reverse(a));
    }

    static public int reverse(int x) {
        int temp = x;
        if (x < 0) {
            temp = -x;
        }
        String s = String.valueOf(temp);
        char[] cs = s.toCharArray();
        StringBuilder newstr = new StringBuilder();
        for (int i = cs.length - 1; i >= 0; i--) {
            newstr.append(cs[i]);
        }
        Integer result;
        try {
            result = Integer.valueOf(newstr.toString());
            if (x < 0) {
                result = result * (-1);
            }
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
}
