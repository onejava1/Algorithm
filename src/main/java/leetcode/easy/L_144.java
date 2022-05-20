package leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class L_144 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
      // 前序遍历
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty() || root != null){
           while (root != null){
                res.add(root.val);
                stack.addFirst(root);
                root = root.left;
           }
           root = stack.removeLast();
           root = root.right;
        }
        return res;
    }


}
