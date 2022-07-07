package niuke;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

/**
 * @author huang.fei
 * @version 1.0
 * @description 最长公共子序列
 * @date 2022/6/15 20:47
 **/

public class BM65 {
    // 这个题是请求公共子序列更简单一点
    // 最长公共子序列 abcd1 acd就是abcd1的子序列
    public String LCS (String s1, String s2) {
        int[][] dpHelp = new int[s1.length() + 1][s2.length() + 1];
        dpHelp[0][0] = 0;
        int res = 0;
        // 初始化第一行
        for (int i = 1; i < dpHelp.length; i++){
            for (int j = 1; j < dpHelp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dpHelp[i][j] = dpHelp[i - 1][j - 1] + 1;
                } else {
                    dpHelp[i][j] = Math.max(dpHelp[i][j - 1], dpHelp[i - 1][j]);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LocalDateTime d1 = LocalDateTime.of(LocalDate.of(2022, 6, 1), LocalTime.MIN);
        LocalDateTime d2 = LocalDateTime.of(LocalDate.of(2020, 6, 2), LocalTime.MIN);
        LocalDateTime d3 = LocalDateTime.of(LocalDate.of(2022, 6, 7), LocalTime.MIN);
        LocalDateTime d5 = LocalDateTime.of(LocalDate.of(2022, 6, 8), LocalTime.MAX);
        System.out.println(d1.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        System.out.println(d2.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        System.out.println(d3.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        System.out.println(d5.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());


        System.out.println(LocalDate.now().toString());
    }

}
