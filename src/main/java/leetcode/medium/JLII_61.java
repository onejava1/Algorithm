package leetcode.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author huang.fei
 * @version 1.0
 * @description 和最小的K个数对
 * @date 2022/6/13 17:23
 **/
public class JLII_61 {
    // 解法是优先队列 采用优先队列
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // k是初始化容量的含义
        // 因为有序 所以对象 x, y来说 下一个只有可能是 x + 1, y 或者是 x, y + 1
        PriorityQueue<int[]> help = new PriorityQueue<int[]>(k, (a, b) -> {
            return a[1] + a[0] - b[0] - b[1];
        });
        int min = nums1.length > k ? k : nums1.length;
        int c = nums2.length > min ? min : nums2.length;
        // todo 待做
        return null;
    }


    public static void main(String[] args) {
        JLII_61 j = new JLII_61();
        int[] a = {1,2};
        int[] c = {3};
        j.kSmallestPairs(a, c, 3);
    }
}
