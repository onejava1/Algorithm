package leetcode.medium;

/**
 * @author huang.fei
 * @version 1.0
 * @description 寻找峰值
 * @date 2022/6/15 17:02
 **/
public class L_162 {
    //
    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (right + left) >> 1;
            // 需要保证Mid + 1 和mid - 1不越界
            if(mid + 1 < nums.length && mid - 1 >= 0){
                //
                if(nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]){
                   return mid;
                }else if (nums[mid - 1] > nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if (mid - 1 < 0){
                if (nums[mid] > nums[mid + 1]){
                    return mid;
                }
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }




}
