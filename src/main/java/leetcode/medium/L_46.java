package leetcode.medium;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
 * @author huang.fei
 * @version 1.0
 * @description 全排列
 * @date 2022/6/11 16:42
 **/
public class L_46 {


    int[] vis;
    // 全排列 nums中的整数互不相同
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        vis = new int[nums.length];
        backTracking(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void backTracking(int index, int[] nums, List<Integer> collector, List<List<Integer>> res){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>(collector);
            res.add(list);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            // 当前位置是否被使用过
            if (vis[i] == 1){
                continue;
            }

            if (vis[i] == 0){
                // 没有被访问过
                collector.add(nums[i]);
                vis[i] = 1;
                backTracking(index + 1, nums, collector, res);

            }
            vis[i] = 0;
            collector.remove(collector.size() - 1);
        }
    }

    public static void main(String[] args) {
        L_46 l = new L_46();
        int[] c = {1, 2, 3};
        l.permute(c);
    }

}
