package com.cjf.剑指Offer;

import java.util.Stack;

/**
 * @Descpription 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @Author CJF
 * @Date 2019/2/22 10:54
 *
 * 解法：
 *
 * 压栈对比 相等则出栈  出栈序列下标右移 否则继续压栈
 *
 * 若最后栈中还有元素 表示 非弹出序列
 *
 *
 *
 **/
public class A21_栈的压入_弹出序列 {

    static public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length > pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i <= pushA.length; i++) {
            if (!stack.empty()) {
                for (; index < popA.length; ) {
                    if (stack.peek() == popA[index]) {
                        stack.pop();
                        index++;
                    } else {
                        break;
                    }
                }
            }
            if (i < pushA.length) {
                stack.push(pushA[i]);
            }
        }
        System.out.println(stack);
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(push, pop));
    }

}
