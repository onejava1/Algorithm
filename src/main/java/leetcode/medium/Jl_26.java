package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TimerTask;

public class Jl_26 {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(A);
        while (!deque.isEmpty()){
            TreeNode treeNode = deque.removeLast();
            // 是否有一个节点与另外一个节点的头部相同 保证所有节点都会和B树的头部比较到
            if (treeNode.val == B.val){
                boolean b = get(treeNode, B);
                if (b){
                    return true;
                }
            }
            if (treeNode.left != null) {
                deque.addFirst(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.addFirst(treeNode.right);
            }
        }
        return false;
    }
    private boolean get(TreeNode r1, TreeNode r2){
          Deque<TreeNode> treeNode1 = new ArrayDeque<>();
          Deque<TreeNode> treeNode2 = new ArrayDeque<>();
          treeNode1.add(r1);
          treeNode2.add(r2);
          while (!treeNode2.isEmpty()){
              TreeNode node1 = treeNode1.removeLast();
              TreeNode node2 = treeNode2.removeLast();
              if (node1.val != node2.val){
                  return false;
              }
              if (node1.left != null && node2.left != null){
                    treeNode1.addFirst(node1.left);
                    treeNode2.addFirst(node2.left);
              }else if (node2.left != null && node1.left == null){
                  return false;
              }

              if (node1.right != null && node2.right != null){
                  treeNode1.addFirst(node1.right);
                  treeNode2.addFirst(node2.right);
              }else if (node2.right != null && node1.right == null){
                  return false;
              }
          }
          return true;
    }

    // 思路和我的一样
    // 但是效率最高
    // 先序遍历每个节点
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B)

                ||
                //
                isSubStructure(A.left, B) ||
                //
                isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) {return true;}
        // 数值不相同
        if(A == null || A.val != B.val) {return false;}
        // 两个节点的左树和左数 右树和右树都相同
        // 必须要都相同
        return recur(A.left, B.left) && recur(A.right, B.right);
    }




    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2);
        node1.right = node2;

        node3.right = node4;
        node4.left = node5;

        Jl_26 jl_26 = new Jl_26();
        boolean b = jl_26.isSubStructure(node1, node3);
        System.out.println(b);

    }
}
