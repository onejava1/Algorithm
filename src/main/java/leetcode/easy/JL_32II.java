package leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class JL_32II {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        var queue = new ArrayDeque<TreeNode>();
        var res = new ArrayList<List<Integer>>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            List<Integer> help = new ArrayList<>();
            int size = queue.size();
            // 一层一层的装进去
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeLast();
                help.add(treeNode.val);
                if (treeNode.left != null){
                    queue.addFirst(treeNode.left);
                }
                if (treeNode.right != null){
                    queue.addFirst(treeNode.right);
                }
            }
            res.add(help);
        }
        return res;
    }
}
