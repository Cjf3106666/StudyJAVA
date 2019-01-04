package com.cjf.LeedCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Descpription 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @Author CJF
 * @Date 2019/1/3 17:53
 **/
public class 最长连续数 {
    public static void main(String[] args) {
        int[] num = {0, -1};
        System.out.println(Solution(num));
    }

    static public int Solution(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>(16);
        int max = 0;
        for (Integer e : nums
                ) {
            map.put(e, false);
        }
        for (Integer e : map.keySet()
                ) {
            if (map.get(e) == true) {
                continue;
            }
            map.put(e, true);
            int count = 1;
            int temp1 = e + 1;
            int temp2 = e - 1;
            while (true) {
                if (map.get(temp1) != null && map.get(temp1) != true) {
                    map.put(temp1, true);
                    count++;
                    temp1++;
                } else {
                    break;
                }
            }
            while (true) {
                if (map.get(temp2) != null && map.get(temp2) != true) {
                    map.put(temp2, true);
                    count++;
                    temp2--;
                } else {
                    break;
                }
            }
            max = max > count ? max : count;
        }
        System.out.println(map);
        return max;
    }
}
