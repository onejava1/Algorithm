package leetcode.weekilycompetion;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class L_6005 {
    public class Code implements Comparable<Code> {
        int key;
        int times;
        Code(int key, int times){
            this.key = key;
            this.times = times;
        }
        @Override
        public int compareTo(Code o) {
            return o.times - this.times;
        }
    }

    public int minimumOperations(int[] nums) {
        if (nums.length < 2){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> helpMap = new HashMap<>();
        PriorityQueue<Code> one = new PriorityQueue<>();
        PriorityQueue<Code> two = new PriorityQueue<>();
        // 天生会多一个
        for (int i = 0; i < nums.length; i += 2) {
            Integer orDefault = map.getOrDefault(nums[i], 0);
            orDefault++;
            map.put(nums[i], orDefault);
        }
        for (int i = 1; i < nums.length; i += 2) {
            Integer orDefault = helpMap.getOrDefault(nums[i], 0);
            orDefault++;
            helpMap.put(nums[i], orDefault);
        }
        map.forEach((key, value)->{
            Code c = new Code(key, value);
            one.add(c);
        });
        helpMap.forEach((key, value)->{
            Code c = new Code(key, value);
            two.add(c);
        });
        Code remove = one.remove();
        Code remove1 = two.remove();
        int res = nums.length;;
        for (;;){
            if (remove.key == remove1.key){
                if (remove.times > remove1.times) {
                    res -= remove.times;
                    if (two.isEmpty()){
                        break;
                    }else {
                        remove1 = two.remove();
                    }
                } else {
                    res -= remove1.times;
                    if (one.isEmpty()){
                        break;
                    }else {
                        remove = one.remove();
                    }
                }
            }else {
                return nums.length - remove.times - remove1.times;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L_6005 l = new L_6005();
        int[] c = {2,2};
        System.out.println(l.minimumOperations(c));
    }
}
