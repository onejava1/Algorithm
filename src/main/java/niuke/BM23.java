package niuke;


import niuke.enity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 数据源属性信息
 *
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/11 14:28
 **/
public class BM23 {


    // 前序遍历
    // 头 左 右
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        // 队列
        Deque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (!deque.isEmpty() || root != null){
            while (root != null){
                list.add(root.val);
                deque.addFirst(root);
                root = root.left;
            }
            // 从最左子树开始往上获取右子树节点的内容
            TreeNode treeNode = deque.removeFirst();
            // 开始判断是否有右子树
            root = treeNode.right;
        }
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
