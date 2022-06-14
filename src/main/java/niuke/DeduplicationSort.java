package niuke;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/14 0:14
 **/
public class DeduplicationSort {

    // 先去重再排序吧
    public int[] getAns(int[] ac){
        Set<Integer> set = new HashSet<>();
        for (int i : ac) {
            set.add(i);
        }
        Integer[] integers = set.toArray(new Integer[set.size()]);
        int[] res = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            res[i] = integers[i];
        }
        quick_sort(res, 0, res.length - 1);
        return res;
    }
    //
    public static int[] quick_sort(int[] num, int l, int r){
        //r为数组元素总个数，last下标等于r-1

        int first=l,last=r,key=num[first];
        while(first<last){
            // 寻找第一个last大于key
            while(first<last&&num[last]>=key){
                --last;
            }
            //如果值小于 key分界值 交换
            num[first]=num[last];
            while(first<last&&num[first]<key){
                ++first;
            }
            //如果值大于key分界值 交换
            num[last]=num[first];
        }
        num[first]=key;
        //递归左右部分进行快排
        if (first>l) {
            num=quick_sort(num, l, first);
        }
        if (first+1<r){
            num=quick_sort(num,first+1,r);
        }
        return num;
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        DeduplicationSort d = new DeduplicationSort();
        int[] help = { 1, 3, -1, 2, 90, 34, 23, 54, 22, 22, 111, 32, 0};
        int[] ans1 = d.getAns(help);
        for (int i = 0; i < ans1.length; i++) {
            System.out.println(ans1[i]);
        }
    }
}
