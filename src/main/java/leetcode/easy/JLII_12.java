package leetcode.easy;

public class JLII_12 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 左侧和
        int[] leftsum = new int[nums.length];
        leftsum[0] = 0;
        for (int i = 1; i < leftsum.length; i++) {
            leftsum[i] = leftsum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < leftsum.length; i++) {
            if (leftsum[i] == sum - leftsum[i] - nums[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JLII_12 l = new JLII_12();
        int[] help = {1,7,3,6,5,6};
        System.out.println(l.pivotIndex(help));
    }
}
