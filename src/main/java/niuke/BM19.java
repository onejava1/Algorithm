package niuke;

/**
 * @author huang.fei
 * @version 1.0
 * @description 寻找数组的峰值
 * @date 2022/6/15 16:54
 **/
public class BM19 {

    // 使用logn时间复杂度
    // 数组中前后两个元素不相等
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
