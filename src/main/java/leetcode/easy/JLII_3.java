package leetcode.easy;

/**
 *  前n个数字中二进制中1的个数
 */
public class JLII_3 {
    public int[] countBits(int n) {
        int[] help = new int[n + 1];
        help[0] = 0;
        for (int i = 1; i < help.length; i++) {
            if (i % 2 == 0){
                help[i] = help[i / 2];
            }else {
                help[i] = help[i - 1] + 1;
            }
        }
        return help;
    }
}
