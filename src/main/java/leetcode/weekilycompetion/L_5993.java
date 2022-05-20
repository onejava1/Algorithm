package leetcode.weekilycompetion;

import java.util.HashMap;
import java.util.HashSet;

public class L_5993 {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(original)){
            original *= 2;
        }
        return original;
    }

    public static void main(String[] args) {
        L_5993 l = new L_5993();
        int[] help = {2,7,9};
        System.out.println(l.findFinalValue(help, 2));
    }
}
