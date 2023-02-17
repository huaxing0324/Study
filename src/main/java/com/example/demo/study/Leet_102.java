package com.example.demo.study;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet_102 {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    public List<List<TreeNode>> levelOrder(TreeNode root) {
        ArrayList<List<TreeNode>> ret = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<TreeNode> curLevel = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode poll = queue.poll();
                curLevel.add(poll);
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }

            }
            ret.add(curLevel);

        }
        return ret;


    }
}
