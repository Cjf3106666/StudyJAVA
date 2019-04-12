package com.cjf.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Descpription
 *
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *               8
 *      	   /  \
 *    	      6   4
 *      	 / \  / \
 *       	5  7 7 11
 *
 * @Author CJF
 * @Date 2019/2/22 16:45
 **/
public class A24_二叉树中和为某一值的路径 {
    ArrayList<Integer> routeList=new ArrayList<>();
    ArrayList<ArrayList<Integer>> allRoute= new ArrayList<>();
     public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null) {
            return allRoute;
        }
        routeList.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null){
            allRoute.add(new ArrayList<>(routeList));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);

        routeList.remove(routeList.size()-1);

        return allRoute;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(new A24_二叉树中和为某一值的路径().FindPath(root, 19));
    }


}
