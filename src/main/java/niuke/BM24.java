package niuke;

import niuke.enity.TreeNode;

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
 * @date 2022/6/11 15:55
 **/
public class BM24 {

    /**
     * 中序遍历 左头右
     * @param root
     * @return
     */
    public int[] inorderTraversal (TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        //
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty() || root != null){
            while (root != null){
                queue.addFirst(root);
                root = root.left;
            }
            TreeNode treeNode = queue.removeFirst();
            list.add(treeNode.val);
            // 开始判断是否有右子树
            if (treeNode.right != null) {
                root = treeNode.right;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }



}
