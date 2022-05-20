package leetcode.weekilycompetion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.jar.JarOutputStream;

public class L_5990 {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        map.forEach((key, value)->{
            if (value != 1){
                return;
            }else {
                Integer a = map.getOrDefault(key + 1, 0);
                Integer b = map.getOrDefault(key - 1, 0);
                if (a == 0 && b == 0){
                    res.add(key);
                }
            }
        });
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,6,5,8};
        L_5990 l_5990 = new L_5990();
        List<Integer> lonely = l_5990.findLonely(nums);
        lonely.forEach((x)->{
            System.out.println(x);
        });
    }
}
