package huawei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Three {

    public static int min = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String substring = s1.substring(1, s1.length() - 1);
        String[] split = substring.split(",");
        int[][] ac = new int[split.length / 2][2];
        int k = 0;
        for (int i = 0; i < split.length; i++) {
            if(i % 2 == 0){
                String replace = split[i].replace("[", "");
                ac[k][0] = Integer.valueOf(replace);
            }else {
                String replace = split[i].replace("]", "");
                ac[k][1] = Integer.valueOf(replace);
                k++;
            }
        }
        getAns1(ac);
        System.out.println(min);

    }
    public static void getAns1(int[][] nums){
        // 按照长宽进行
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer list = map.getOrDefault(nums[i][0], Integer.MAX_VALUE);
            int min = Math.min(list, nums[i][1]);
            map.put(nums[i][0], min);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int[][] ac = new int[map.size()][2];
        int k = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer>  a = iterator.next();
            int l = a.getKey();
            int c = a.getValue();
            ac[k][0] = l;
            ac[k][1] = c;
            k++;
        }
        digui(ac, 0, 0, -1);
    }

    public static void digui(int[][] ac, int index, int sum, int preIndex){
        if (index == ac.length){
            // 走到最后一本了
            min = Math.max(sum, min);
            return;
        }
        if(preIndex == -1){

          digui(ac, index + 1, sum, preIndex);

          // 选择了要这本书
          digui(ac, index + 1, sum + 1, index);
        } else {
            int l = ac[preIndex][0];
            int w = ac[preIndex][1];
            if(ac[index][0] > l && ac[index][1] > w){
                // 可以要 选择要这本书籍
                digui(ac, index + 1, sum + 1, index);
                // 可以选择这本书的情况下 放弃掉这边呢书
                digui(ac, index + 1, sum, preIndex);
            }

            // 不可以要
            digui(ac, index + 1, sum, preIndex);
        }
    }

}
