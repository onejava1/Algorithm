package leetcode.medium;

public class JL_47 {
    public int maxValue(int[][] grid) {
        int steap = steap(grid, 0, 0, 0);
        return steap;
    }
    private int steap(int[][] grid, int i, int r, int pre){
        if (i == grid.length - 1 && r == grid[0].length - 1){
            return pre + grid[i][r];
        }
        int r1 = 0;
        int d1 = 0;
        if (i < grid.length - 1){
            r1 = steap(grid, i + 1, r, pre + grid[i][r]);
        }
        if (r < grid[0].length - 1) {
           d1 = steap(grid, i, r + 1, pre + grid[i][r]);
        }
        return Math.max(r1, d1);
    }


    public int maxValue1(int[][] grid) {
        // i , j 位置可以得到的最大最多礼物
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int i1 = dp[0].length - 1; i1 >= 0; i1--) {
                // 最后一行
                if (i == dp.length - 1){
                    // 最后一列
                    if (i1 == dp[0].length - 1) {
                        dp[i][i1] = grid[i][i1];
                    }else {
                        dp[i][i1] = grid[i][i1] + dp[i][i1 + 1];
                    }
                    continue;
                }else if (i1 == dp[0].length - 1){
                    // 最后一列
                    dp[i][i1] = grid[i][i1] + dp[i + 1][i1];
                }else {
                    // 不是最后一行也不是最后一列
                    dp[i][i1] = grid[i][i1] +  Math.max(dp[i + 1][i1], dp[i][i1 + 1]);
                }
                }
        }
        return dp[0][0];
        }



    public static void main(String[] args) {
        JL_47 jl_47 = new JL_47();
        int[][] help = {
                {1,2,3},
                {4,5,6},
//                {4,2,1},
        };
        int i = jl_47.maxValue1(help);
        System.out.println(i);
    }
}
