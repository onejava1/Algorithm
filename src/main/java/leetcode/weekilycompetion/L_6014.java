package leetcode.weekilycompetion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L_6014 {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] chars = s.toCharArray();
        boolean[] isVsited = new boolean[chars.length];
        StringBuilder res = new StringBuilder();
        Arrays.sort(chars);
        int left = s.length() - 1;
        int right = s.length() - 1;
        char pre = chars[s.length() - 1];
        int size = 0;
        while (left >= 0){
            if (isVsited[left]){
                left--;
                continue;
            }
            if (chars[left] == pre){
                // 已经满了
                if (size == repeatLimit){
                    while (right >= 0){
                        if (chars[right] != pre) {
                            if (isVsited[right]){
                                if (right == 0){
                                    return res.toString();
                                }
                            }else {
                                res.append(chars[right]);
                                isVsited[right] = true;
                                pre = chars[right];
                                break;
                            }
                        }
                        if (right == 0){
                            return res.toString();
                        }
                        right--;
                    }
                }else {
                    isVsited[left] = true;
                    res.append(chars[left]);
                    size++;
                    left--;
                }
            }else {
                res.append(chars[left]);
                pre = chars[left];
                isVsited[left] = true;
                size = 1;
                left--;
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        L_6014 l = new L_6014();
        System.out.println(l.repeatLimitedString("aaddppprrrr",
                1));
    }
}
