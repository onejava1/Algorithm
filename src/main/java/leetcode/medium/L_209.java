package leetcode.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *
 * @author huang.fei
 * @version 1.0
 * @description 大于 target的最小子数组
 * @date 2022/6/11 18:55
 **/
public class L_209 {

    // 正整数
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target){
            return 0;
        }
        while (left <= right){
           int needReduce = nums[left] > nums[right] ? nums[right--] : nums[left++];
           sum -= needReduce;
            System.out.println(needReduce);
           if (sum == target){
               return right - left + 1;
           }
           if (sum < target){
               return right - left + 2;
           }
        }
        return -1;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int target = Integer.parseInt(line);
            line = in.readLine();
            int[] nums = stringToIntegerArray(line);

            int ret = new L_209().minSubArrayLen(target, nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
