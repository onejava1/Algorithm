package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class JLII_15 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] pH = new int[26];
        int[] tmp = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            int t = s.charAt(i) - 'a';
            pH[index]++;
            tmp[t]++;
        }
        for (int i = 0; i < tmp.length; i++) {
            if (pH[i] != tmp[i]){
                break;
            }
            if (i == tmp.length - 1){
                res.add(0);
            }
        }


        int left = 0;
        while (left < s.length()){
            int a = s.charAt(left) - 'a';
            int index = left + p.length() >= s.length() ? -1 : left + p.length();
            if (index == -1){
                return res;
            }
            int b = s.charAt(index) - 'a';
            tmp[a]--;
            tmp[b]++;
            left++;
            for (int i = 0; i < tmp.length; i++) {
                if (pH[i] != tmp[i]){
                    break;
                }
                if (i == tmp.length - 1){
                    res.add(left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String b = "abc";
        JLII_15 l = new JLII_15();
        System.out.println(l.findAnagrams(s, b));
    }
}
