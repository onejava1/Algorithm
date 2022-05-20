package leetcode.medium;

public class L_11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right){
           int tmp = (right - left) * Math.min(height[left], height[right]);
           res = Math.max(res, tmp);
           int t = height[left] > height[right] ? right-- : left++;
        }
        return res;
    }
}
