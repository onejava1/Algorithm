package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JLII_7 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                break;
            }else if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }else {
                twoSum(i, -nums[i], nums, res);
            }
        }
        return res;
    }

    private void twoSum(int i, int target, int[] nums, List<List<Integer>> res){
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] < target){
                left++;
            }else if (nums[left] + nums[right] > target){
                right--;
            }else if (nums[left] + nums[right] == target){
                if (left != i + 1 && nums[left] == nums[left - 1] || (right != nums.length - 1) && nums[right] == nums[right + 1]) {
                    int c = nums[left] == nums[left - 1] ? left++ : right--;
                    continue;
                }
                List<Integer> arrayList = List.of(nums[i], nums[left], nums[right]);
                res.add(arrayList);
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] c = {-1,0,1,2,-1,-4};
        JLII_7 l = new JLII_7();
        List<List<Integer>> lists = l.threeSum(c);
        lists.forEach((x)->{
            System.out.println(x);
        });

    }

}
