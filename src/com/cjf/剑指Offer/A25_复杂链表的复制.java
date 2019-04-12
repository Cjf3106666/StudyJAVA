package com.cjf.剑指Offer;

/**
 * @Descpription
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @Author CJF
 * @Date 2019/2/25 10:08
 **/
public class A25_复杂链表的复制 {
  static RandomListNode newHead=null;
  static   public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null) {
            return newHead;
        }
        Clone2(pHead);
        return newHead;
    }
    static public RandomListNode Clone2(RandomListNode head){
      if(head==null) {
          return newHead;
      }
      newHead=new RandomListNode(head.label);
      if(head.random!=null) {
         newHead.random=new RandomListNode(head.random.label);
         Clone2(head.random);
      }
      if(head.next!=null){
          newHead.next=new RandomListNode(head.next.label);
          Clone2(head.next);
      }
    return newHead;
    }
    public static void main(String[] args) {
        RandomListNode randomListNode=new RandomListNode(1);
        RandomListNode randomListNode2=new RandomListNode(2);
        RandomListNode randomListNode3=new RandomListNode(3);
        RandomListNode randomListNode4=new RandomListNode(4);
        RandomListNode randomListNode5=new RandomListNode(5);
        RandomListNode randomListNode6=new RandomListNode(6);

        randomListNode.next=randomListNode2;
        randomListNode2.next=randomListNode3;
        randomListNode3.next=randomListNode4;
        randomListNode4.next=randomListNode5;
        randomListNode5.next=randomListNode6;
/*
        randomListNode.random=randomListNode5;
        randomListNode2.random=randomListNode2;
        randomListNode3.random=randomListNode;
        randomListNode4.random=randomListNode6;
        randomListNode5.random=randomListNode3;
*/
        System.out.println(Clone(randomListNode).label);
    }
}
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
    static void display(RandomListNode head){

    }
}