package niuke.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 全排列 组合是 n 选 m记住顺序 n ! / (n - m) !
 * 不记住顺序 n ! / (n -m) ! * m !
 * @author huang.fei
 * @version 1.0
 * @description 在数组中选取所有所有组合 使得能力数值达到一个目标数值
 * @date 2022/6/13 22:29
 **/
public class ComposePair {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        int[] data = new int[i];
        for (int h = 0; h < i; h++){
            data[h] = s.nextInt();
        }
        int target = s.nextInt();
        System.out.println(getAns(data, target));
    }

    public static int getAns(int[] nums, int target){
        int sum = 0;
        Map<Integer, Integer> times = new TreeMap<>();
        for (int num : nums) {
            Integer d = times.getOrDefault(num, 0);
            times.put(num, d + 1);
        }
        for (Map.Entry<Integer, Integer> e : times.entrySet()){
            Integer key = e.getKey();
            Integer value = e.getValue();
            //
            if (key > target / 2 ){
                break;
            }
            int need = target - key;
            if(need == key){
                // value的全排列
                sum += get(value);
                continue;
            }
            if(times.get(need) != null){
                sum += times.get(need) * value;
            }
        }
        return sum;
    }
    public static int get(int a){
        return a * (a - 1) / 2;
    }
//    9 1 1 1 2 2 2 3 3 3 4
}
