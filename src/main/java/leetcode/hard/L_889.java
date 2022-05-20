package leetcode.hard;

public class L_889 {
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

    int[] pre, post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return buildeTree(0, 0, pre.length);
    }

    /**
     *  preIndex 前序遍历中 分支开始的坐标
     *  PostIndex 后序遍历中 分支开始的坐标
     *  m代表该段落有多少个
     */
    public TreeNode buildeTree(int preIndex, int postIndex, int m){
        if (m == 0){
            return null;
        }
        // 代表的头节点
        TreeNode head = new TreeNode(pre[preIndex]);
        if (m == 1){
            return head;
        }
        // 寻找左子树的大小

        int tmp = postIndex;
        //  寻找子数组的左子树的大小
        // 判断左子树的大小 下一段分支的头节点
        while (post[tmp] != pre[preIndex + 1]){
            tmp++;
        }
        int l = tmp - postIndex + 1;

        // 开始分组
        head.left = buildeTree(preIndex + 1, postIndex , l);
        // 右子树的节点
        head.right = buildeTree(preIndex + 1 + l, postIndex + l , m - l - 1);

        return head;
    }


}
