
package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class JL_37 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    private final int em = -2000;
    // 寻找一个在整个树之外的数据用来做特殊标记
    TreeNode emp = new TreeNode(em);

    // 层序
    public String serialize(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        StringBuilder res = new StringBuilder();
        queue.addFirst(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.removeLast();
            if (treeNode != null){
                res.append(treeNode.val);
                queue.addFirst(treeNode.left == null ? emp : treeNode.left);
                queue.addFirst(treeNode.right == null ? emp : treeNode.right);
            }else {
                res.append("null");
            }
            res.append("_");
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        var queue = new ArrayDeque<TreeNode>();
        String[] s = data.split("_");
        TreeNode t = new TreeNode(Integer.parseInt(s[0]));
        queue.addFirst(t);
        for (int i = 1; i < s.length; i++) {
            TreeNode treeNode = queue.removeLast();
            int left = Integer.parseInt(s[i]);
            int right = Integer.parseInt(s[i + 1]);
            if (left != em){
                TreeNode leftnode = new TreeNode(left);
                treeNode.left = leftnode;
                queue.addFirst(leftnode);
            }
            if(right != em){
                TreeNode rightnode = new TreeNode(right);
                treeNode.right = rightnode;
                queue.addFirst(rightnode);
            }
        }
        return t;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        treeNode4.left = treeNode6;
        treeNode4.right = treeNode7;

        JL_37 jl_37 = new JL_37();
        String serialize = jl_37.serialize(treeNode1);
        TreeNode deserialize = jl_37.deserialize(serialize);

    }
    
}
