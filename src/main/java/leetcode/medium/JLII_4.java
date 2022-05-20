package leetcode.medium;

public class JLII_4 {
    // 只出现一次的数字
    int ans = 0;
    public int singleNumber(int[] nums) {
        int c = 0;
        for (int i = 0; i < 32; i++){
            c = 0;
            // 将所有数字的该位置上的数记录下来
            for (int num : nums) {
                c += ((num >> 1) & 1);
            }
            if (c % 3 != 0){
                ans |= (1 << i);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(5 >> 1);
    }
}
