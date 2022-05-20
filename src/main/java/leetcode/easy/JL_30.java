package leetcode.easy;

import java.util.ArrayList;

public class JL_30 {

    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();

    public void push(int x) {
        list1.add(x);
        if (list2.isEmpty()){
            list2.add(x);
        }else {
            Integer integer = list2.get(list2.size() - 1);
            Integer add = integer > x ? x : integer;
            list2.add(add);
        }
    }

    public void pop() {
        list1.remove(list1.size() - 1);
        list2.remove(list2.size() - 1);
    }

    public int top() {
        return list1.get(list1.size() - 1);
    }

    public int min() {
        return list2.get(list2.size() - 1);
    }

}
