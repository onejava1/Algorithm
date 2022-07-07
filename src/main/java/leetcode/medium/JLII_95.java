package leetcode.medium;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/15 20:58
 **/
public class JLII_95 {

    public int longestCommonSubsequence(String text1, String text2) {
        // write code here
        // 两个字符串的最长公共子序列
        // 其实最多也就两行
        int[][] dpHelp = new int[text1.length() + 1][text2.length() + 1];
        dpHelp[0][0] = 0;
        int res = 0;
        // 初始化第一行
        for (int i = 1; i < dpHelp.length; i++){
            for (int j = 1; j < dpHelp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dpHelp[i][j] = dpHelp[i - 1][j - 1] + 1;
                } else {
                    dpHelp[i][j] = Math.max(dpHelp[i][j - 1], dpHelp[i - 1][j]);
                }
            }
        }
        return dpHelp[text1.length()][text2.length()];
    }


}
