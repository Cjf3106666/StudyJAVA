package com.cjf.剑指Offer;

import java.util.ArrayList;

/**
 * @Descpription 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @Author CJF
 * @Date 2019/2/20 11:41
 **/
public class A03_从头到尾打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        list.add(listNode.val);
        while (listNode.next != null) {
            list.add(listNode.next.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> newList=new ArrayList<>(list.size());
        for (int i=list.size()-1;i>=0;i--){
            newList.add(list.get(i));
        }
        return newList;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        ListNode listNode2 = new ListNode(13);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(18);
        ListNode listNode5 = new ListNode(15);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ArrayList list = new A03_从头到尾打印链表().printListFromTailToHead(listNode);
        System.out.println(list);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    static void display(ListNode head){
        StringBuilder sb=new StringBuilder();
        while (head!=null){
            sb.append(head.val+" ");
            head=head.next;
        }
        System.out.println(sb);
    }
}