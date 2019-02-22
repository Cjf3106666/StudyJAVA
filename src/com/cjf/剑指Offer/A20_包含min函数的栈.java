package com.cjf.剑指Offer;

/**
 * @Descpription 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @Author CJF
 * @Date 2019/2/22 10:24
 **/

import java.util.Stack;

public class A20_包含min函数的栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        if (stack2.empty()) {
            stack2.push(node);
        } else {
            if (stack2.peek() > node) {
                stack2.push(node);
            }
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.peek().equals(stack2.peek())) {
            stack2.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        A20_包含min函数的栈 stack = new A20_包含min函数的栈();
        stack.push(5);
        stack.push(7);
        stack.push(1);
        stack.push(3);
        System.out.println(stack.min());
    }
}
