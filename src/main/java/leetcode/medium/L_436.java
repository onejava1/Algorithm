package leetcode.medium;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.TreeMap;

public class L_436 {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int index = 0;
        for(int[] row : intervals){
            map.put(row[0], index);
            index++;
        }
        return null;
    }

    public static void main(String[] args) {
//        LocalDateTime l = LocalDateTime.of(2022, 12, 12, 3, 5, 5, 2);
//        LocalDateTime c = LocalDateTime.of(2021, 12, 12, 3, 5, 5, 2);
//
//
//        System.out.println(l.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
//        System.out.println(c.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
//        Long a = 10L;
//        Long b = 8L;
//        System.out.println(a.compareTo(b));
//        long l = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        System.out.println(l);
//        long l1 = LocalDateTime.of(2021, 10, 12, 2, 12, 10).toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        System.out.println(l1);

        String ac = "" +
                "";
//        System.out.println(ac);
        System.out.println(ac);

    }

}
