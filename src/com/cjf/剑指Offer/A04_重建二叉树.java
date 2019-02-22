package com.cjf.剑指Offer;


/**
 * @Descpription 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Author CJF
 * @Date 2019/2/20 11:56
 **/
public class A04_重建二叉树 {
     public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0 || pre == null || in == null) {
            return null;
        }
        TreeNode root =reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);

        return root;
    }
    private TreeNode reConstructBinaryTree(int []pre,int startPre,int endPre,int in[],int startIn,int endIn){
        if(startPre>endPre||startIn>endIn) {
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for (int i=startIn;i<=endIn;i++){
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int []pre={1,2,4,7,3,5,6,8};
        int []in={4,7,2,1,5,3,8,6};
      new A04_重建二叉树().reConstructBinaryTree(pre,in);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


}