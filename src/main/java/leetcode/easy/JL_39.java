package leetcode.easy;

public class JL_39{
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0){
                candidate = num;
            }
            count = num == candidate ? count + 1 : count - 1;
        }
        return candidate;
    }
}
