package com.cjf.剑指Offer;

/**
 * @Descpription
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 * @Author CJF
 * @Date 2019/2/21 17:22
 **/
public class A18_二叉树的镜像 {
  static   public void Mirror(TreeNode root) {
        if(root==null) {
            return ;
        }
        TreeNode temp = null;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.left!=null) {
            Mirror(root.left);
        }

        if(root.right!=null) {
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        TreeNode node1=new TreeNode(6);
        TreeNode node2=new TreeNode(10);
        TreeNode node3=new TreeNode(5);
        TreeNode node4=new TreeNode(7);
        TreeNode node5=new TreeNode(9);
        TreeNode node6=new TreeNode(11);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;

        System.out.println(displayTree(root,new StringBuffer()));
        Mirror(root);
        System.out.println(displayTree(root,new StringBuffer()));
    }

    static public String displayTree(TreeNode root,StringBuffer sb){
        if(root==null) {
            return sb.toString();
        }

        if(root.left!=null) {
            displayTree(root.left,sb);
        }
        sb.append(root.val+" ");
        if(root.right!=null) {
            displayTree(root.right,sb);
        }

        return sb.toString();
    }

}
