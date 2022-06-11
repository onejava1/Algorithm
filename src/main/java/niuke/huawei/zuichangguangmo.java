package niuke.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Handler;

public class zuichangguangmo {
    static int startPoint = 0;
    int[] road = new int[101];
    int maxValue = -1;
    public static void main(String[] args) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        for(int i = 0; i < k; i++){
            int start = s.nextInt();
            int end = s.nextInt();
            Set<Integer> set = map.getOrDefault(start, new HashSet<Integer>());
            set.add(end);
        }
        startPoint = s.nextInt();
        zuichangguangmo z = new zuichangguangmo();
        z.longest(map, startPoint, 0);
        System.out.println(z.maxValue);
    }

    // 找到最长的节点
    public void longest(HashMap<Integer, Set<Integer>> map, Integer start, Integer sum){
        Set<Integer> set = map.get(start);
        for (Integer integer : set) {
            road[start] = 1;
            if(road[integer] == 1){
                maxValue = Math.max(maxValue, sum);
                continue;
            }else {
                longest(map, integer, sum + 1);
            }
        }
    }

}
