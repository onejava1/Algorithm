package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 面试题 04_06
 * 找到在搜索二叉树中大于改节点的最小节点
 */
public class MI_04_06 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right != null){
            // 右子树的左子树就是需要返回的数值
            TreeNode ans = p.right;
            for(;;){
                if(ans.left == null){
                    return ans;
                }
                ans = ans.left;
            }
        }else {
            // 从根节点开始枚举
            TreeNode tmp = root;
            TreeNode ans = root;
            for(;;){
                if(tmp.val > p.val){
                    ans = tmp.val > ans.val ? ans : tmp;
                    tmp = tmp.left;
                }else{
                    tmp = tmp.right;
                }
                if(tmp == null){
                    break;
                }
            }
            return ans;
        }
    }

}
