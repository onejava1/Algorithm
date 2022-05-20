package leetcode.medium;

public class JLII_8 {
    public int minSubArrayLen(int target, int[] nums) {
        int smallLength = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (sum < target && right <= nums.length - 1){
            sum += nums[right];
            right++;
        }
        if (sum < target){
            return 0;
        }
        // 第一个窗口
        right--;
        smallLength = right - left + 1;
        while (right < nums.length - 1){
            //减小窗口
          if (sum - nums[left] >= target){
              sum -= nums[left];
              left++;
              smallLength = Math.min(smallLength, right - left + 1);
          }else {
              right++;
              sum += nums[right];
              smallLength = Math.min(smallLength, right - left + 1);
          }
        }
        while (sum >= target){
            sum -= nums[left];
            left++;
        }
        smallLength =Math.min(right - left + 2, smallLength);
        return smallLength;
    }
    public static void main(String[] args) {
        JLII_8 l = new JLII_8();
        int[] help = {1,1,1};
        System.out.println(l.minSubArrayLen(4, help));
    }

}
