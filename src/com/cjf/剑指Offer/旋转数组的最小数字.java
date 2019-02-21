package com.cjf.剑指Offer;

/**
 * @Descpription 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * @Author CJF
 * @Date 2019/2/20 14:13
 **/
public class 旋转数组的最小数字 {
    //笨方法
   /* static public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return 0;
    }*/
    //二分
    static public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        return BinarySerach(array, 0, array.length - 1);
    }

    static public int BinarySerach(int[] nums, int start, int end) {
        if (start >= end) {
            return nums[0];
        }
        if (end - start == 1) {
            if (nums[end] <= nums[start]) {
                return nums[end];
            } else {
                return nums[start];
            }
        }
        int mid = (start + end) % 2 == 0 ? (start + end) / 2 : (start + end) / 2 + 1;
        if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        } else {
            if (nums[mid] >= nums[start]) {
                return BinarySerach(nums, mid , end);
            } else {
                return BinarySerach(nums, start, mid);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {7, 8, 9, 10, 1, 2, 3, 4};
        System.out.println(minNumberInRotateArray(nums));

    }
}
