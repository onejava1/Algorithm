package leetcode.easy;

public class JL_68II {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 1){
            return target > nums[0] ? 1 : 0;
        }
        int left = 0;
        int right = nums.length - 1;
        boolean isup = nums[1] > nums[0] ? true : false;
        if (isup) {
            // 升序情况下
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    if (mid - 1 < 0) {
                        return 0;
                    }
                    if (target > nums[mid - 1]) {
                        return mid;
                    }
                    right = mid - 1;
                } else if (target > nums[mid]) {
                    if (mid + 1 > nums.length - 1) {
                        return nums.length;
                    }
                    if (target < nums[mid + 1]) {
                        return mid + 1;
                    }
                    left = mid + 1;
                }
            }
        } else {
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (target == nums[mid]) {
                    return mid;
                } else if (target < nums[mid]) {
                    if (mid + 1 > nums.length - 1) {
                        return nums.length - 1;
                    }
                    if (target > nums[mid + 1]) {
                        return mid;
                    }
                    left = mid + 1;
                } else if (target > nums[mid]) {
                    if (mid - 1 < 0) {
                        return 0;
                    }
                    if (target < nums[mid - 1]) {
                        return mid;
                    }
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JL_68II jl_68II = new JL_68II();
        int[] help = {1,3};
        int i = jl_68II.searchInsert(help, 2);
        System.out.println(i);
    }
}
