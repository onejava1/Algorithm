package leetcode.medium;

/**
 * 数值的N整数次方
 */
public class JL_14 {
    // 快速幂
    public double myPow(double x, int n) {
        long b = n;
        double res = 1.0;
        boolean isPositive = false;
        if (b < 0){
            b = -b;
            isPositive = true;
        }
        while (b != 0){
            long c = b & 1;
            if (c == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return  isPositive ? 1 / res : res;
    }
}
