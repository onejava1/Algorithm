package leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 *
 * @author huang.fei
 * @version 1.0
 * @description 二叉树的中序遍历
 * @date 2022/6/11 16:16
 **/
public class L_94 {
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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.addFirst(root);
                root = root.left;
            }
            TreeNode treeNode = stack.removeFirst();
            res.add(treeNode.val);
            if(treeNode.right != null) {
                root = treeNode.right;
            }
        }
        return res;
    }
}
