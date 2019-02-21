package com.cjf.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Descpription 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author CJF
 * @Date 2019/2/20 16:54
 **/
public class 调整数组顺序使奇数位于偶数前面 {

    static public void reOrderArray(int[] array) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int e : array
                ) {
            if (e % 2 != 0) {
                list1.add(e);
            } else {
                list2.add(e);
            }
        }
        int i = 0;
        for (int e : list1
                ) {
            array[i++] = e;
        }
        for (int e : list2
                ) {
            array[i++] = e;
        }

    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
