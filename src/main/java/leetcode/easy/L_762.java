package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 除开1和本身之外没有其他因数被称作质数
 */
public class L_762 {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = new HashSet<Integer>();
        // 2,3,5,7,11,13,17,19
//        可以将2357
//        665772

        int ans = 0;
        for(int i = left; i <= right; i++) {
            int cur = Integer.bitCount(i);
            if(((1 << cur) & 665772) != 0){
                ans++;
            }
        }
        return ans;
    }
}
