package com.cjf.剑指Offer;

import java.util.Stack;

/**
 * @Descpription 输入一个链表，反转链表后，输出新链表的表头。
 * @Author CJF
 * @Date 2019/2/21 11:24
 **/
public class A15_反转链表 {
    static public ListNode ReverseList(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode pre=null;
        ListNode next=null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(ReverseList(listNode).next.val);
    }
}
