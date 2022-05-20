package leetcode.medium;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * 从上倒下打印二叉树
 *
 */
public class Mi32_1 {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        var stack = new ArrayDeque<TreeNode>();
        stack.addFirst(root);
        var res = new ArrayList<Integer>();
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.removeLast();
            res.add(treeNode.val);
            if (treeNode.left != null){
                stack.addFirst(treeNode.left);
            }
            if (treeNode.right != null){
                stack.addFirst(treeNode.right);
            }
        }
        int i = 0;
        var re = new int[res.size()];
        for (Integer integer : res) {
            re[i++] = integer;
        }
        return re;
    }
}
