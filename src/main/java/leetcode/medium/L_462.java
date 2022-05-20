package leetcode.medium;

import java.time.LocalDateTime;

public class L_462 {
    public int minMoves2(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int mid = quickSelect(nums, 0, nums.length - 1,nums.length / 2);
        int ans = 0;
        for(int i : nums){
            ans += Math.abs(i - mid);
        }
        return ans;
    }

    // 选择出数组中第N大的数字
    public int quickSelect(int[] nums, int left, int right ,int n){
        // 任意的一个数字是在整个数组的多少未知
        int k = partition(nums, left, right);
        if(k == n){
            return nums[n];
        }else if(k < n){
            // 选择的数字在中位数左边
            left = k + 1;
            return quickSelect(nums, left, right, n);
        }else if(k > n){
            right = k - 1;
            return quickSelect(nums, left, right, n);
        }
        return -1;
    }

    // 选择出任意一个数字在整个数组中的位数
    public int partition(int[] nums, int left, int right){
        int mid = nums[right];
        int j = left;
        // 最后直接把right 放在所选位置即可
        for(int i = left; i < right; i++){
            if(nums[i] <= mid){
                swap(nums, j, i);
                j++;
            }
        }
        // 直接保证该数字在partion之后的正确的位置
        swap(nums, j, right);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
//        L_462 l = new L_462();
//        int[] nums = {1, 2, 3};
//        l.minMoves2(nums);
        LocalDateTime kc = LocalDateTime.of(2022, 5, 17, 12, 23);
        LocalDateTime k = LocalDateTime.of(2022, 5, 19, 12, 23);
        System.out.println(k.toString());
        System.out.println(kc.toString());
    }


}
