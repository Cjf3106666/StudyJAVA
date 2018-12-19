package com.cjf.LeedCode;

import java.util.*;

/**
 * @Descpription 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @Author CJF
 * @Date 2018/12/19 14:54
 **/
public class 三数之和 {
    public static void main(String[] args) {
        int num[] = {0, 1, -1, 2, -2, 3};
        System.out.println(threeSum(num));
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> moreThanZero = new LinkedList<>();
        List<Integer> lessThanZero = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                moreThanZero.add(nums[i]);
            } else {
                lessThanZero.add(nums[i]);
            }
        }
        Set<List<Integer>> set=new HashSet<>();

        return null;
    }
}
