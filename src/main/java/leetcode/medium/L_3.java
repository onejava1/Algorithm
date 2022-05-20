package leetcode.medium;

import java.util.Arrays;

public class L_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.equals("") || s == null || s.length() == 0){
            return 0;
        }
        int[] times = new int[128];
        Arrays.fill(times, -1);
        int maxWindowSize = 1;
        int left = 0;
        int right = 0;
        int pre = 0;
        for (right = 0; right < s.length(); right++){
            int c = s.charAt(right);
            if (times[c] == -1){
                maxWindowSize = Math.max((right - left + 1), maxWindowSize);
                times[c] = right;
            }else {
                // 出现相等
                left = times[c] + 1;
                while (pre < left){
                    int k = s.charAt(pre++);
                    times[k] = -1;
                }
                times[c] = right;
            }
        }
        return maxWindowSize;
    }

    public static void main(String[] args) {
        L_3 l = new L_3();
        int abcabcbb = l.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(abcabcbb);

    }

}
