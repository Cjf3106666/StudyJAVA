package com.cjf.LeedCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Descpription 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @Author CJF
 * @Date 2019/1/3 12:30
 **/
public class 数字全排列 {

    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        fullSort(list, nums, 0);
        return list;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        System.out.println(permute(nums));
    }

    public static void fullSort(List list, int[] ss, int i) {
        if (i < 0 || ss == null || i >= ss.length) {
            return;
        }
        if (i == ss.length - 1) {
            List<Integer> templist = new LinkedList<>();
            for (Integer a : ss
                    ) {
                templist.add(a);
            }
            if(!list.contains(templist)) {
                list.add(templist);
            }
        } else {
            for (int j = i; j < ss.length; j++) {
                int temp = ss[i];
                ss[i] = ss[j];
                ss[j] = temp;
                fullSort(list, ss, i + 1);
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }
}
