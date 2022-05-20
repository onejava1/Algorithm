package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class L_422 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] == -1){
               continue;
           }else {
               if (nums[nums[i] - 1] == -1) {
                   continue;
               }else {
                   int index = i;
                   while (nums[index] != -1 && nums[nums[index] - 1] != -1){
                       int tmp = nums[index] - 1;
                       nums[index] = nums[nums[index] - 1];
                       nums[tmp] = -1;
                   }
               }
           }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1){
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L_422 l_422 = new L_422();
        int[] nums = {1,1,2};
        List<Integer> duplicates = l_422.findDuplicates(nums);
        System.out.println(duplicates);
    }
}
