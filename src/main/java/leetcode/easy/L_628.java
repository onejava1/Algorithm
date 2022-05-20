package leetcode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L_628 {

    public int maximumProduct(int[] nums) {
        int[] max = new int[3];
        int maxK = 0;
        // 默认大根堆
        int[] small = new int[2];
        int smallK = 0;
        for (int num : nums) {

            if (maxK != 3){
                max[maxK++] = num;
            }else {
                int index = max[0] > max[1] ? max[1] > max[2] ? 2 : 1 : max[0] > max[2] ? 2 : 0;
                if (num > max[index]){
                    max[index] = num;
                }
            }

            if (smallK != 2){
                small[smallK++] = num;
            }else {
                int big = small[0] > small[1] ? 0 : 1;
                if (num < small[big]){
                    small[big] = num;
                }
            }

        }
        int maxindex = max[0] > max[1] ? max[0] > max[2] ? max[0] : max[2] : max[1] > max[2] ? max[1] : max[2];
        int a = small[0] * small[1] * maxindex;
        int b = max[0] * max[1] * max[2];
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        L_628 l_628 = new L_628();
        int[] nums = {-1,-2,-3};
        System.out.println(l_628.maximumProduct(nums));
    }

}
