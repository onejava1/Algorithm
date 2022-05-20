package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class JL_38 {

    HashSet<String> res = new HashSet<String>();
    boolean[] help = null;
    public String[] permutation(String s) {
        int index = 0;
        help = new boolean[s.length()];
        backTracking(s, new StringBuilder(), 0, res);
        String[] s1 = new String[res.size()];
        for (String re : res) {
            s1[index++] = re;
        }
        return s1;
    }
    private void backTracking(String s, StringBuilder tmp, int size, HashSet<String> res){
        if (size == s.length()){
            String s1 = tmp.toString();
            res.add(s1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!help[i]) {
                // 没加入过
                tmp.append(s.charAt(i));
                help[i] = true;
                backTracking(s, tmp, size + 1, res);
                help[i] = false;
                tmp.deleteCharAt(tmp.length() - 1);
            }else {
                continue;
            }
        }
    }

    // 采用借助力扣31的下一个序列
    public String[] permutation1(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String s1 = new String(chars);
        List<String> res = new ArrayList<>();
        res.add(s1);
        for (;;){
            String next = next(chars);
            if (!s1.equals(next)){
                res.add(next);
                chars = next.toCharArray();
            }else {
                break;
            }
        }
        return res.toArray(new String[res.size()]);
    }
    private String next(char[] chars){
        int i = chars.length - 2;
        // 找到最左边的较小数字
        while (i >= 0 && chars[i] >= chars[i + 1]){
            i--;
        }

        if (i >= 0){
            // 如果找到第一个较小数字
            int j = chars.length - 1;
            while (j >= 0 && chars[i] >= chars[j]){
                j--;
            }
            swap(i, j, chars);
        }
        reverse(i + 1, chars);
        return new String(chars);
    }
    private void swap(int i, int j, char[] nums){
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int i, char[] nums){
        int rightIndex = nums.length - 1;
        while (i <= rightIndex){
            swap(i, rightIndex, nums);
            i++;
            rightIndex--;
        }
    }
    public static void main(String[] args) {
        JL_38 jl_38 = new JL_38();
        String[] abcs = jl_38.permutation1("aab");
        for (String abc : abcs) {
            System.out.println(abc);
        }
    }
}
