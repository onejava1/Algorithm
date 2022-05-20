package leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * 正数除法
 */
public class JLII_1 {


    public int divide(int a, int b) {
        int res = 0;
        int tmp = b;
        int times = 1;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        if (a == Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }
        if (b == 1){
            return a;
        }else if (b == -1){
            return -a;
        }
        // 加法容易溢出 使用减法
        while (a < 0){
            map.put(tmp, times);
            res += times;
            a -= tmp;
            tmp += tmp;
            times += times;
        }
        int h = a + tmp;
        Map.Entry<Integer, Integer> entry = map.floorEntry(h);
        while (h < b){
            h -= entry.getKey();
            res += entry.getValue();
            entry = map.floorEntry(h);
        }
        return res;
    }




    public static void main(String[] args) {
        JLII_1 jlii_1 = new JLII_1();
        int divide = jlii_1.divide(1100540749,
                5);
        System.out.println(divide);

    }

}
