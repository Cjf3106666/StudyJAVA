package com.cjf.剑指Offer;

import java.util.Stack;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/2/20 13:13
 **/
public class A05_用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.empty()) {
            int temp = stack2.pop();
            stack1.push(temp);
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int result = stack2.pop();
        return result;
    }
}
