package leetcode.weekilycompetion;

public class L_5989 {
    public int countElements(int[] nums) {
        int max = -100000;
        int min = 100000;
        int deletimes = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max || nums[i] == min){
               deletimes++;
            }
        }
        return nums.length - deletimes;
    }

    public static void main(String[] args) {
        int[] nums = {11,7,2,5};
        L_5989 l = new L_5989();
        System.out.println(l.countElements(nums));
    }
}
