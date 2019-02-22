package com.cjf.剑指Offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Descpription
 *              8
 * *     	   /  \
 * *     	  6   10
 * *     	 / \  / \
 * *     	5  7 9 11
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * @Author CJF
 * @Date 2019/2/22 11:30
 * <p>
 * 解法：
 * 借助一个辅助队列 先进先出的特点。
 * 根节点入队列，出队列 若被弹出的节点有左右子节点，左子节点先入队列，右节点入队列，重复此操作直至队列为空。
 * <p>
 * 例如： 1.  ⑧入队列 ⑧出队列
 * 2.  ⑥入队列 ⑩入队列  此时队列中为  ⑥⑩
 * 3.  ⑥出队列 ⑤ ⑦入队列 此时队列中为 ⑩⑤⑦  重复此操作
 **/
public class A22_从上往下打印二叉树 {


    static public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>(10);
        if (root == null) {
            return list;
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = ((LinkedList<TreeNode>) queue).pollFirst();
            list.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(PrintFromTopToBottom(root));
    }
}
