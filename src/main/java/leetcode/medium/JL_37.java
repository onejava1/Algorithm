package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class JL_37 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


  public int getSum(TreeNode root, int preSUm){
        // 叶子节点 就返回路径和
        if (root == null){
            return preSUm;
        }

       return Math.max(getSum(root.left, preSUm + root.val),
               getSum(root.right, preSUm + root.val));
  }


    int level = 1;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
