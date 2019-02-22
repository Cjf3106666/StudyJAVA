package com.cjf.剑指Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Descpription 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *               8
 * * *     	   /  \
 * * *     	  6   10
 * * *     	 / \  / \
 * * *     	5  7 9 11
 *
         * 5-7-6-9-11-10-8
 * @Author CJF
 * @Date 2019/2/22 15:43
 *
 *  最右必定为根节点   如果根节点左边的第一个数 小于根节点。那么说明根节点左边的序列应全部小于根节点
 *
 *  如果根节点左边的数大于根节点，则判断左边序列是否有小于根节点的 节点。如果存在，则根节点 既有左子节点，又有右子节点，否则根节点只有右节点。
 *
 *  不论哪种情况 必须满足 根节点的左子树 全部小于根节点， 根节点的右子树全部大于根节点！
 *
 **/
public class A23_二叉搜索树的后序遍历 {


    static public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return VerifySquenceOfBST2(sequence, 0, sequence.length - 1);
    }

    static public boolean VerifySquenceOfBST2(int[] nums, int start, int rootIndex) {
        if (rootIndex == 0 || start >= rootIndex) {
            return true;
        }
        int root = nums[rootIndex];
        if (nums[rootIndex - 1] <= root) {
            for (int i = start; i < rootIndex; i++
                    ) {
                if (nums[i] > root) {
                    return false;
                }
            }
            VerifySquenceOfBST2(nums, start, rootIndex - 1);
        } else {
            for (int j = rootIndex - 1; j >= start; j--) {
                if (nums[j] <= root) {
                    VerifySquenceOfBST2(nums, start, j);
                    VerifySquenceOfBST2(nums, j + 1, rootIndex - 1);
                    for (int k = 0; k < j; k++) {
                        if (nums[k] > root) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            for (int i = start; i < rootIndex; i++
                    ) {
                if (nums[i] <= root) {
                    return false;
                }
            }
            VerifySquenceOfBST2(nums, start, rootIndex - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 6, 5};
        System.out.println(VerifySquenceOfBST(nums));
    }
}
