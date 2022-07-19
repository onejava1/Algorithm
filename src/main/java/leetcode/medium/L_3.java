package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class L_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Integer, Integer> dict = new HashMap<>();
        int res = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) - 'a';
            if (dict.containsKey(key)){
                int preSeameNumberIndex = dict.get(key);
                pre = preSeameNumberIndex + 1;
                dict.put(key, i);
            }else {
                res = Math.max(res, i - pre + 1);
                dict.put(key, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L_3 l = new L_3();
        int abcabcbb = l.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(abcabcbb);

    }

}
