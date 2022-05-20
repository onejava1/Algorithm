package leetcode.medium;

public class JLII_13 {

    // 一维前缀和
    int[][] help;
    public JLII_13(int[][] matrix) {
        help = new int[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < help[0].length; j++) {
                help[i][j] = help[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2 ; i++) {
            sum += help[i][col2 + 1] - help[i][col1];
        }
        return sum;
    }
}
