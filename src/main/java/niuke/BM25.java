package niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author huang.fei
 * @version 1.0
 * @description 二叉树的后序遍历 需要一个Pre节点
 * @date 2022/6/17 15:47
 **/
public class BM25 {
    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
    }

    // 后序遍历 左右头
    public int[] postorderTraversal (TreeNode root) {
        // write code here
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode pre = null;
        while (stack.isEmpty() || root != null){
            //
            while (root != null){
               stack.addFirst(root);
               root = root.left;
            }

            TreeNode treeNode = stack.removeFirst();

            if (treeNode.right == null && treeNode != pre){
                res.add(treeNode.val);
                root = treeNode.right;
                stack.addFirst(treeNode);
            }else {
                // 右子树为空说明是叶子节点 可以被进行收集了
                res.add(treeNode.val);

            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
