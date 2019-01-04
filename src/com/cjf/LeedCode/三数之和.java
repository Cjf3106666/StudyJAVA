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
 *
 * 备注 领扣提示超时~无奈
 **/
public class 三数之和 {
    public static void main(String[] args) {
        long begin=System.currentTimeMillis();
        int num[] = {7,-13,-1,1,-6,14,10,-2,1,9,11,-10,8,-10,14,13,-1,4,-6,-3,-5,3,3,12,-5,11,5,-6,-2,0,-6,12,3,0,-2,12,-1,-7,-5,8,10,13,13,3,10,12,-7,-6,-7,-5,-1,3,5,-13,-8,-15,13,13,-14,-12,-2,-5,-15,8,11,-1,6,-13,-1,8,10,-14,-1,0,-4,-6,-3,5,-4,-2,7,10,8,-3,12,-14,-10,3,14,-9,-2,-11,-6,-9,13,12,-3,4,14,3,-11,2,5,-5,-13,-14,-3,-8};
        System.out.println(threeSum(num));
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
    }

    static public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3)return result;
        for (int i = 0; i < nums.length; i++) {
            list.add(new Integer(nums[i]));
        }
        for (Integer e1 : list
                ) {
            if (e1 > 0) {
                continue;
            }
            for (Integer e2 : list
                    ) {
                if (e1 == e2) {
                    continue;
                }
                for (Integer e3 : list
                        ) {
                    if (e2 == e3||e1==e3) {
                        continue;
                    }
                    if ((e3 + e2) == (-e1)) {
                        List<Integer> temp = new ArrayList<>();
                        if (e1 <= e2 && e1 <= e3) {
                            temp.add(e1);
                            if (e2 > e3) {
                                temp.add(e3);
                                temp.add(e2);
                            } else {
                                temp.add(e2);
                                temp.add(e3);
                            }
                            set.add(temp);
                        } else if (e2 <= e1 && e2 <= e3) {
                            temp.add(e2);
                            if (e1 > e3) {
                                temp.add(e3);
                                temp.add(e1);
                            } else {
                                temp.add(e1);
                                temp.add(e3);
                            }
                            set.add(temp);
                        } else if (e3 <= e2 && e3 <= e1) {
                            temp.add(e3);
                            if (e2 > e1) {
                                temp.add(e1);
                                temp.add(e2);
                            } else {
                                temp.add(e2);
                                temp.add(e1);
                            }
                            set.add(temp);
                        }

                    }
                }
            }

        }
        result.addAll(set);
        return result;
    }
}
