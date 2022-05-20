package leetcode.medium;

public class JLII_16 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int maxLen = 1;
        int left = 0;
        int right = 0;
        int[] window = new int[128];
        while (right < s.length()){
            // 没有被访问过
         int index = s.charAt(right);
         window[index]++;
         // 无重复
         if (window[index] == 1){
             // 更新
             maxLen = Math.max(right - left + 1, maxLen);
         }else {
             // 有重复
            maxLen = Math.max(right - left, maxLen);
         }
         while (window[index] > 1) {
             window[s.charAt(left)]--;
             left++;
         }
         right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Integer a = 217;
        Integer b = 217;

//        String s = "pwwkew";
//        JLII_16 l = new JLII_16();
//        l.lengthOfLongestSubstring("pwwkew");
    }

}
