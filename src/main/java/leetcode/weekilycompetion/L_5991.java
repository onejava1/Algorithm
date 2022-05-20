package leetcode.weekilycompetion;

public class L_5991 {
    // 非原地修改
    public int[] rearrangeArray(int[] nums) {
        int[] help = new int[nums.length];
        int positive = 0;
        int negitive = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                help[positive] = nums[i];
                positive += 2;
            }
            if (nums[i] < 0){
                help[negitive] = nums[i];
                negitive += 2;
            }
        }
        return help;
    }


    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        L_5991 l = new L_5991();
        int[] help = {-37,-10,-9,15,14,31};

        for (int i = 0; i < help.length; i++) {
            System.out.println(help[i]);
        }
    }
}
