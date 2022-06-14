package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author huang.fei
 * @version 1.0
 * @description 全排列2
 * @date 2022/6/11 17:28
 **/
public class L_47 {
    int[] vis;
   // 重复数字下的全排列
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(0, new ArrayList<Integer>(), nums, res);
        return res;
    }

    public void backTracking(int index, List<Integer> list, int[] nums, List<List<Integer>> res){

        if(index == nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i] == 1){
                continue;
            }
            // 在这个index中只可以在从前往右填入一次 其他次都作废
            if(i != 0 && nums[i] == nums[i - 1] && vis[i - 1] == 1){
                continue;
            }
            vis[i] = 1;
            list.add(nums[i]);
            backTracking(index + 1, list, nums, res);
            vis[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        L_47 l = new L_47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = l.permuteUnique(nums);
        System.out.println(lists);

    }

}
