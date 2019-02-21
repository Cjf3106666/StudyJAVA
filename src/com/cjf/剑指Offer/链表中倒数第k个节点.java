package com.cjf.剑指Offer;

/**
 * @Descpription 输入一个链表，输出该链表中倒数第k个结点。
 * @Author CJF
 * @Date 2019/2/21 10:54
 **/
public class 链表中倒数第k个节点 {
    static public ListNode FindKthToTail(ListNode head, int k) {
        if (k == 0 || head == null) {
            return null;
        }
        int c = 0;
        ListNode count = head;
        while (count != null) {
            c++;
            count = count.next;
        }
        if (k > c) return null;
        ListNode tempHead = head;
        ListNode tempMid = head;
        for (int i = 0; i < k; i++) {
            tempMid = tempMid.next;
        }
        while (tempMid != null) {
            tempHead = tempHead.next;
            tempMid = tempMid.next;
            if (tempMid == null) {
                break;
            }
        }
        return tempHead;
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
        System.out.println(FindKthToTail(listNode, 6).val);
    }
}

