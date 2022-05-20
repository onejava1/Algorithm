package interviewtest;

import java.util.ArrayList;
import java.util.TreeMap;

public class Bole2 {

    public class Node{
        // 存储相同元素的最小的下标
        public int min = 0;
        public int max = 0;

    }

//    双指针
    public int maxArea (ArrayList<Integer> height) {
        int res = 0;
        TreeMap<Integer, Node> map = new TreeMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height.size(); i++) {
            int k = height.get(i);
            max = Math.max(k, max);
            min = Math.min(k, min);
            if (map.containsKey(k)) {
                Node node = map.get(k);
                node.max = Math.max(node.max, i);
                node.min = Math.min(node.min, i);
            }else {
                Node node = new Node();
                node.min = i;
                node.max = i;
                map.put(k, node);
            }
        }

        for (int i = 0; i < height.size(); i++) {

            int c = height.get(i);
            for (;;){
                int tmp = c;
                while (tmp <= max){
                    if (map.containsKey(tmp)) {
                        Node node = map.get(tmp);
                        if (node.max > i) {
                            res = Math.max(Math.abs(node.max - i) * c, res);
                        }
                        if (node.min < i){
                            res = Math.max(Math.abs(node.min - i) * c, res);
                        }

                    }
                    tmp++;
                }
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Bole2 b = new Bole2();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(b.maxArea(list));
    }

}
