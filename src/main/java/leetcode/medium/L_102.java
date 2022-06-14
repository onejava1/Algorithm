package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 数据源属性信息
 *
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/11 15:32
 **/
public class L_102 {
    
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode() {
          }

          TreeNode(int val) {
              this.val = val;
          }

          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;

          }
      }
      public List<List<Integer>> levelOrder(TreeNode root) {
          if (root == null){
              return new ArrayList<>();
          }
          Deque<TreeNode> queue = new ArrayDeque<>();
          queue.addFirst(root);
          List<List<Integer>> list = new ArrayList<>();
          while (!queue.isEmpty()){
              List<Integer> list1 = new ArrayList<>();
              for (int i = 0; i < queue.size(); i++){
                  TreeNode treeNode = queue.removeLast();
                  if (treeNode.right != null){
                    queue.addFirst(treeNode.right);
                  }
                  if(treeNode.left != null){
                      queue.addFirst(treeNode.left);
                  }
                  list1.add(treeNode.val);
              }
          }
          return list;
      }


}
