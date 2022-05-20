package leetcode.medium;

/**
 * 机器人的运动范围
 * 需要读懂题 它不一定可以到达终点
 */
public class JL_13 {
    public int movingCount(int m, int n, int k) {
        int[][] help = new int[m][n];
        help[0][0] = 1;
        int sum = 0;
        // 从下往上
        for (int i = 0; i <= m - 1; i++) {
            // 从右往左
            for (int j = 0; j <= n - 1; j++) {
                if (getSum(i, j) <= k){
                    // 第一行
                    if (i == 0){
                       if (j == 0){
                           sum = 1;
                           continue;
                       }else {
                           help[i][j] = help[i][j - 1];
                       }
                    }else {
                        // 不是第一行
                        if (j == 0){
                            help[i][j] = help[i - 1][j];
                        }else {
                            help[i][j] = help[i - 1][j] == 1 || help[i][j - 1] == 1 ? 1 : 0;
                        }

                    }
                }
                sum += help[i][j];
            }
        }
        return sum;
    }

    // 优化版本 辅助空间只需要两行即可
    public int movingCount1(int m, int n, int k) {
        int[][] help = new int[2][n];
        help[0][0] = 1;
        int sum = 0;
        // 从下往上
        for (int i = 0; i <= m - 1; i++) {
            // 从右往左
            for (int j = 0; j <= n - 1; j++) {
                if (getSum(i, j) <= k){
                    // 第一行
                    if (i == 0){
                        if (j == 0){
                            sum = 1;
                            continue;
                        }else {
                            help[i][j] = help[i][j - 1];
                        }
                    }else {
                        // 不是第一行
                        if (j == 0){
                            help[i][j] = help[i - 1][j];
                        }else {
                            help[i][j] = help[i - 1][j] == 1 || help[i][j - 1] == 1 ? 1 : 0;
                        }

                    }
                }
                sum += help[i][j];
            }
        }
        return sum;
    }
    private int getSum(int col, int row){
        int res = 0;
        while (col != 0){
            res += col % 10;
            col /= 10;
        }
        while (row != 0){
            res += row % 10;
            row /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        JL_13 jl_13 = new JL_13();
        int sum = jl_13.movingCount(7, 2, 3);
        System.out.println(sum);
    }
}
