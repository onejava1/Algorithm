package leetcode.weekilycompetion;

import java.util.ArrayList;
import java.util.List;

public class L_5981 {
    public List<Integer> maxScoreIndices(int[] nums) {
        // 以i做分界
        int[] help = new int[nums.length + 1];
        int[] leftzero = new int[nums.length + 1];
        int[] rightone = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        int max = -1;
        leftzero[0] = 0;
        for (int i = 1; i < leftzero.length; i++) {
            int a = nums[i - 1] == 0 ? 1 : 0;
            leftzero[i] = leftzero[i - 1] + a;
        }
        rightone[nums.length - 1] = 0;
        for (int i = rightone.length - 2; i >= 0; i--) {
            int a = nums[i] == 1? 1 : 0;
            rightone[i] = rightone[i + 1] + a;
        }
        for (int i = 0; i < help.length; i++) {
            help[i] = leftzero[i] + rightone[i];
            max = Math.max(max, help[i]);
        }
        for (int i = 0; i < help.length; i++) {
            if (help[i] == max){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L_5981 l = new L_5981();
        int[] c = {0,0,1,0};
        List<Integer> list = l.maxScoreIndices(c);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
