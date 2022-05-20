package leetcode.hard;

import javax.naming.NamingEnumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class JlII_17 {

    public int a = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JlII_17 jlII_17 = (JlII_17) o;
        return a == jlII_17.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        // 代表是否全部使用
        int[] tmp = new int[58];
        for(int i = 0; i < t.length(); i++){
            int k = t.charAt(i) - 'A';
            int c = s.charAt(i) - 'A';
            tmp[k]++;
            tmp[c]--;
        }
        if(isZero(tmp)){
            return s.substring(0, t.length());
        }
        String c = "";
        int maxSize = s.length() + 1;
        int left = 0;
        int right = t.length();
        while(right < s.length() && left < right){
            int index = s.charAt(right) - 'A';
            tmp[index]--;
            // 尽量的去缩减
            while (isZero(tmp)){
                // 更新长度
                c = right - left + 1 > maxSize ? c : s.substring(left, right + 1);
                maxSize = c.length();
                tmp[s.charAt(left++) - 'A']++;
            }
            right++;
        }
        return c;

    }


    private boolean isZero(int[] nums){
        for(int ze : nums){
            if(ze > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        JlII_17 l = new JlII_17();
        System.out.println(l.minWindow(s, t));
//        int b = 'z' - 'A';
//        System.out.println(b);
    }

}
