package leetcode.medium;

import java.util.ArrayList;

public class JLII_9 {


    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int mul = 1;
        int res = 0;
        for(;right<n;right++){
//            当 mul<k , 不断扩展滑动窗口的右边界right
            mul *= nums[right];
            //当 mul>= k, 收缩滑动窗口的左边界
            while(left<=right&&mul>=k){
                res += n-right;
                mul /= nums[left++];
            }
        }
        return n*(1+n)/2-res;
    }

    public static void main(String[] args) {
        int[] a = {10,5,2,6,7};
        JLII_9 l = new JLII_9();
        int c = 100;

    }
}
