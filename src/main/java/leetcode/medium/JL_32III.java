package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JL_32III {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        var levelNumber = 0;
        var queue = new ArrayDeque<TreeNode>();
        var res = new ArrayList<List<Integer>>();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            var list = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeLast();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.addFirst(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addFirst(treeNode.right);
                }
            }
            if (levelNumber % 2 == 0){
                res.add(list);
            }else {
                Collections.reverse(list);
                res.add(list);
            }
            levelNumber++;
        }
        return res;
    }
}
