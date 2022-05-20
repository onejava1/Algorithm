package leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class L_954 {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 把0取出出去
        if((map.getOrDefault(0, 0) % 1) == 1){
            return false;
        }
        List<Integer> array = new ArrayList<>();
        for (int i : map.keySet()) {
            array.add(i);
        }
        Collections.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        for (Integer integer : array) {
            if (map.getOrDefault(2 * integer, 0) < map.get(integer)){
                return false;
            }
            map.put(2 * integer, map.getOrDefault(2 * integer, 0) - map.get(integer));
        }
        return true;
    }

    public boolean canReorderDoubled1(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<Integer>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }



    public static void main(String[] args) {
        int[] a = {2,1,2,1,1,1,2,2};
        L_954 l = new L_954();
        l.canReorderDoubled1(a);
    }
}
