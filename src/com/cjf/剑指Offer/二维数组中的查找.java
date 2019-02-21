package com.cjf.剑指Offer;

/**
 * @Descpription 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author CJF
 * @Date 2019/1/9 16:31
 **/
public class 二维数组中的查找 {
    static public boolean Find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        if (array[0].length == 0) {
            return false;
        }
        if (target < array[0][0]) {
            return false;
        }
        if (target > array[array.length - 1][array[0].length - 1]) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (target < array[i][0] || target > array[i][array[i].length - 1]) {
                continue;
            }
            for (int j = 0; j < array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{}};

        System.out.println(Find(6, nums));

    }
}
