package leetcode.medium;

import java.util.concurrent.CountDownLatch;

/**
 * 从前序和中序遍历构造二叉树
 */
public class L_105 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
     }

    // 前序 头 左 右
    // 中序 左 头 右
    int[] pre;
    int[] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pre = preorder;
        this.in = inorder;
        return rebuildTree(0, preorder.length - 1, 0, preorder.length - 1);
    }
    // m代表该分支树的个数
    public TreeNode rebuildTree(int preI, int preIend,int inI, int inIend){

        TreeNode head = new TreeNode(pre[preI]);
        if (preI == preIend){
           return head;
        }
        int i = inI;
        for (i = inI; inI < inIend; i++){
            if (pre[preI] == in[i]){
                break;
            }
        }
        // 找到左子树的大小
        int leftNum = i - inI;


        head.left = rebuildTree(preI + 1, preI + leftNum, inI, inI + leftNum);
//        head.right = rebuildTree(preI + leftNum + 1, i + 1, m - lsize - 1);
        return head;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(4);
        count.await();
    }

}
