package classicalgorithm.Tree;

import leetcode.hard.L_1206;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Tree {

    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

    }

    TreeNode root = null;

    public void insert(int t){
        if (root == null){
            root = new TreeNode();
            root.val = t;
        }else {
            TreeNode ans = getAns(t, root);
            if (ans.val < t){
                TreeNode node = new TreeNode();
                node.val = t;
                ans.right = node;
            }else if (ans.val > t){
                TreeNode node = new TreeNode();
                node.val = t;
                ans.left = node;
            }
        }

    }



    private TreeNode getAns(int t, TreeNode node){
        if (node.val < t){
            if (node.right != null){
                return getAns(t, node.right);
            }else {
                return node;
            }
        }else {
            if (node.left != null){
                return getAns(t, node.left);
            }else {
                return node;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode tmp = root;
        while (!queue.isEmpty() || tmp != null){
            while (tmp != null){
                queue.addFirst(tmp);
                tmp = tmp.left;
            }
            tmp = queue.removeFirst();
            res.add(tmp.val);
            if (tmp.right != null){
                tmp = tmp.right;
            }else {
                tmp = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(0);
        tree.insert(1);
        tree.insert(4);
        tree.insert(2);
        tree.insert(15);

        List<Integer> list = tree.inorderTraversal(tree.root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


}
