package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class JL_33 {

    // 根据后序遍历的特点 对于任意子树范围内的 最后一个必定是头节点
    // 搜索二叉树的前序遍历是升序
    public boolean verifyPostorder(int[] postorder) {
        return isSearchTree(postorder, 0, postorder.length - 1);
    }
    private boolean isSearchTree(int[] nums, int start, int end){
        if (start >= end){
            return true;
        }
        int p = start;
        while (nums[p] < nums[end]){
            p++;
        }
        // p - 1其实没有删除掉前一段二叉树的头节点
        int m = p;
        while (nums[m] > nums[end]){
            m++;
        }
        // 必须要 m == end表示整段都必须符合要求
        return m == end && isSearchTree(nums, start, p - 1) && isSearchTree(nums, p , end - 1);
    }



    public static void main(String[] args) {
        JL_33 jl_33 = new JL_33();
        int[] help = {5,4,3,2,1};
        System.out.println(jl_33.verifyPostorder(help));
    }
}
