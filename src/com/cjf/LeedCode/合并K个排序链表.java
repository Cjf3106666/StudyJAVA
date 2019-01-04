package com.cjf.LeedCode;

import java.util.*;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/1/3 10:10
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 *
 **/
public class 合并K个排序链表 {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>(Arrays.asList(1, 4, 5));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(1, 3, 4));
        List<Integer> list3 = new LinkedList<>(Arrays.asList(2, 6));
        Queue<Integer> queue = new PriorityQueue<>();
        queue.addAll(list1);
        queue.addAll(list2);
        queue.addAll(list3);
        int lenght = queue.size();
        for (int i = 0; i < lenght; i++) {
            if (i == lenght - 1) {
                System.out.print(queue.poll());
            } else {
                System.out.print(queue.poll() + "->");
            }
        }

    }

}
