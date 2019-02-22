package com.cjf.剑指Offer;

/**
 * @Descpription 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Author CJF
 * @Date 2019/2/21 14:58
 **/
public class A17_树的子结构 {
    static public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null||root2==null) {
            return false;
        }
        String s1=displayTree(root1,new StringBuffer());
        String s2=displayTree(root2,new StringBuffer());
        System.out.println(s1+"\n"+s2);
        return s1.contains(s2);
    }
    static public String displayTree(TreeNode root,StringBuffer sb){
        if(root==null) {
            return sb.toString();
        }
        sb.append(root.val);
        if(root.left!=null) {
            displayTree(root.left,sb);
        }
        if(root.right!=null) {
            displayTree(root.right,sb);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode root2 = new TreeNode(3);
        TreeNode node11 = new TreeNode(6);
        TreeNode node12 = new TreeNode(7);
        root2.left = node11;
        root2.right = node12;

        System.out.println(HasSubtree(root1, root2));
    }
}
