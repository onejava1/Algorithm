package leetcode.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 *
 * @author huang.fei
 * @version 1.0
 * @description 根据后序和中序遍历构造二叉树
 * @date 2022/6/11 20:20
 **/
public class L_106 {

    public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    /**
     * 后序 左 右 头
     * 中序 左 头 右
     * 根据中序来构建二叉树
     */
    HashMap<Integer, Integer> map;
    int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

       postIndex = postorder.length - 1;
        return buildATree(inorder, postorder, 0, inorder.length - 1);
    }

    /**
     * 从start到right 构建树
     * 后序 左 右 头
     * 中序 左 头 右
     * @param inorder
     * @param postorder
     * @param start
     * @param right
     * @return
     */
    public TreeNode buildATree(int[] inorder, int[] postorder, int start, int right) {
        if (start > right){
            return null;
        }

        // 中序头节点
        int head = postorder[postIndex--];
        int headIndex = map.get(head);
        TreeNode headPoint = new TreeNode(head);
        // 左子树的头节点
        TreeNode leftNode = buildATree(inorder, postorder, start, headIndex - 1);
        TreeNode rightNode = buildATree(inorder, postorder, headIndex + 1, right);
        headPoint.left = leftNode;
        headPoint.right = rightNode;
        return headPoint;
    }

    int[] postorder;
    int[] inorder;
    int post_idx;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();


    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }





    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            int k = 1;
            String ac = null;
            String kc = null;
            while (k != 0){
                ac = scanner.nextLine();
                kc = scanner.nextLine();
                k--;
            }

            int[] inorder = stringToIntegerArray(ac);
            int[] postorder = stringToIntegerArray(kc);
            TreeNode ret = new L_106().buildTree1(inorder, postorder);
            String out = treeNodeToString(ret);
            System.out.print(out);

    }



}
