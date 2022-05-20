package leetcode.medium;

/**
 * 阶乘后的0
 */
public class L_172 {

    // 任何范围内 来说 一般都是5的质因数字会比2的少
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0){
            n /= 5;
            res += n;
        }
        return res;
    }




}
