package com.example.demo.study;

import java.util.concurrent.atomic.AtomicLong;

public  class Offer68_公共祖先 {
   static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[9];
        for (int i = 0; i <= 8; i++) {
            TreeNode n = new TreeNode(i);
            nodes[i] = n;
        }
        nodes[3].left = nodes[5];
        nodes[3].right = nodes[1];

        nodes[5].left = nodes[6];
        nodes[5].right = nodes[2];

        nodes[1].left = nodes[0];
        nodes[1].right = nodes[8];

        nodes[2].left = nodes[7];
        nodes[2].right = nodes[4];

        find(nodes[3],nodes[6],nodes[4]);

    }

    static TreeNode find(TreeNode node,TreeNode p, TreeNode q){
       if(node == null || node == p || node == q) return node;
        int cur = node.val;

       TreeNode left = find(node.left,p,q);
       TreeNode right = find(node.right,p,q);
        if(left == null && right == null){

            return null;
        }else if(left == null && right != null){
            System.out.println("right:" + right.val);
            return right;
        }else if(left != null && right == null){
            System.out.println("left:" + left.val);
            return left;
        }
        System.out.println("result:" + node.val);
        return node;
    }


}
