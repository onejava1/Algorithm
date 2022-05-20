package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 插入和删除都是o(1)的时间复杂度
 *
 */
public class L_380 {

//    public RandomizedSet() {
//
//    }


    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();


    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Integer valIndex = map.get(val);
            Integer lastNumber = list.get(list.size() - 1);
            map.remove(val);
            list.set(valIndex, lastNumber);
            list.remove(list.size() - 1);

            return true;
        }else {
            return false;
        }
    }

    public int getRandom() {
        Random r = new Random();
        int c = (r.nextInt(1) + (list.size() - 1));
        int i = c == 0 ? 0 : c - 1;
        return list.get(i);
    }

    public static void main(String[] args) {
        L_380 l = new L_380();
        l.insert(0);
        l.insert(1);
        l.remove(0);
        l.insert(2);
        l.remove(1);
        System.out.println(l.getRandom());
    }
}
