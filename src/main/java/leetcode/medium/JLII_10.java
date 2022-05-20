package leetcode.medium;

import java.util.HashMap;

public class JLII_10 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int findtarget = sum - k;
            if (map.get(findtarget) != null){
                res += map.get(findtarget);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        JLII_10 l = new JLII_10();
        int[] c = {1,2,1,2,1};
        System.out.println(l.subarraySum(c, 3));
    }
}
