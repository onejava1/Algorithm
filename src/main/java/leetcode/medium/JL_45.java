package leetcode.medium;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class JL_45 {
    // 归并排序
    public String minNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] help = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            help[i] = String.valueOf(nums[i]);
        }
        mergeSort(help, 0, nums.length - 1);
        for (String num : help) {
            res.append(num);
        }
        return res.toString();
    }
    private void mergeSort(String[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private void merge(String[] nums, int left, int mid, int right){
        String[] tmp = new String[right - left + 1];
        int lstart = left;
        int rstart = mid + 1;
        int k = 0;
        while (lstart <= mid && rstart <= right){
            if ((nums[lstart] + nums[rstart]).compareTo(nums[rstart] + nums[lstart]) < 0){
                tmp[k++] = nums[lstart++];
            }else {
                tmp[k++] = nums[rstart++];
            }
        }
        while (lstart <= mid){
            tmp[k++] = nums[lstart++];
        }
        while (rstart <= right){
            tmp[k++] = nums[rstart++];
        }
        for (int i = 0, i1 = left; i < tmp.length; i++, i1++) {
            nums[i1] = tmp[i];
        }
    }


    public static void main(String[] args) {
        JL_45 jl_45 = new JL_45();
        int[] nums = {3,30,34,5,9};
        String s = jl_45.minNumber(nums);
        System.out.println(s);
    }

}
