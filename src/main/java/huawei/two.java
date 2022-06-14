package huawei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class two {

    public static void main(String[] args) {
        int[][] ac = new int[3][4];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            for (int k = 0; k < 4; k++){
                ac[i][k] = s.nextInt();
            }
        }

        System.out.println(get(ac));

    }
    public static int get(int[][] nums){
        int[][] a = getOne(nums[0]);
        int[][] b = getOne(nums[1]);
        int[][] c = getOne(nums[2]);
        int[][] ints = twoReduce(a, b);
        if(ints == null){
            return 0;
        }
        int[][] ints1 = twoReduce(ints, c);
        if (ints1 == null){
            return 0;
        }
        int k = Math.max(ints1[0][1], ints1[0][0]) -  Math.min(ints1[0][1], ints1[0][0]);
        int kc = Math.max(ints1[1][1] , ints1[1][0]) -  Math.min(ints1[1][1] , ints1[1][0]);
        return Math.abs(k * kc);
    }
    public static int[][] getOne(int[] nums){
        int[][] a = new int[2][2];
        a[0][0] = nums[0];
        a[0][1] = nums[0] + nums[2];

        a[1][0] = nums[1] - nums[3];
        a[1][1] = nums[1];

        return a;
    }

    public static int[][] twoReduce(int[][] a, int[][] b){
        int[][] res = new int[2][2];
        // 判断是否相交
        if (a[0][0] >= b[0][1] || a[0][1] <= b[0][0] ){
            return null;
        }
        if(a[1][0] >= b[1][1] || a[1][1] <= b[1][0]){
            return null;
        }

        res[0][0] = a[0][0] > b[0][0] ? a[0][0] : b[0][0];
        res[0][1] = a[0][1] < b[0][1] ? a[0][1] : b[0][1];
        res[1][0] = a[1][0] > b[1][0] ? a[1][0] : b[1][0];
        res[1][1] = a[1][1] < b[1][1] ? a[1][1] : b[1][1];
        return res;
    }



    public static int getAns(int[][] nums){
        // 按照长宽进行
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i][0], new ArrayList<>());
            list.add(nums[i][1]);
            map.put(nums[i][1], list);
        }
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        int prel = Integer.MAX_VALUE;
        int prew = Integer.MAX_VALUE;
        int sum = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Integer>>  a = iterator.next();
            int l = a.getKey();
            List<Integer> value = a.getValue();
            int w = Integer.MAX_VALUE;
            for (Integer integer : value) {
                w = Integer.min(w, integer);
            }
            if(l < prel &&  w < prew){
                sum++;
            }
        }
        return sum;
    }
}
