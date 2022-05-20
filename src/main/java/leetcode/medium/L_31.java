package leetcode.medium;

/**
 * 下一个排列
 */
public class L_31 {
    public void nextPermutation(int[] nums) {
       int i = nums.length - 2;
       // 从左往右找到第一个较小的数字 因为较小数字必须相对在左边 较大数字必须较大做右边
       while (i >= 0 && nums[i] >= nums[i + 1]){
           i--;
       }
       // 由上诉的查找逻辑 我们得出i +1, end一定是降序排列
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            swap(i, j ,nums);
        }
        reverse(nums, i + 1);
    }
    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(left, right, nums);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        L_31 l_31 = new L_31();
        int[] nums = {1,2};
        l_31.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
