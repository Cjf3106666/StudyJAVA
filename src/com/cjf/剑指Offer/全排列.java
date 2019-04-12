package com.cjf.剑指Offer;

import java.util.Arrays;

/**
 * @Descpription
 * @Author CJF
 * @Date 2019/3/28 11:48
 **/
public class 全排列 {
    static  StringBuffer sb=new StringBuffer();
    public static void main(String[] args) {
        int num[] = {1,2,3};
        FullSort(num,0);
        System.out.println(sb.toString());
    }

    public static void FullSort(int [] nums, int i){
        if(i >= nums.length || nums.length == 0) {
            return;
        }
        if(i==nums.length-1){
            sb.append(Arrays.toString(nums) + "\n");
        }
        for (int j=i;j<nums.length;j++){
            swap(nums,i,j);
            FullSort(nums,i+1);
            swap(nums,i,j);
        }
    }

    public static void swap(int nums[], int m, int n){
        if(nums.length==0||m==n||m>=nums.length||n>=nums.length) {
            return;
        }
        int temp = nums[m] ;
        nums[m]=nums[n];
        nums[n]=temp;
    }

}
