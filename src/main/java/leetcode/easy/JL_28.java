package leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class JL_28 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    // 和原来101一样 是反转二叉树
    public boolean isSymmetric(TreeNode root) {
        return digui(root, root);
    }
    private boolean digui(TreeNode node, TreeNode node1){
        if (node == null && node1 == null){
            return true;
        }
        if (node == null || node1 == null){
            return false;
        }
        if (node.val != node1.val){
            return false;
        }
        return node.val != node1.val && digui(node.left, node1.right) && digui(node.right, node1.left);
    }


}
