package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 8皇后问题
// n * n的矩阵 n个皇后 不可以在同一行 同一列
// 同一个对角线 请问有多少种摆放方法
public class ML_0812 {

//     非位图版本的递归版本

//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> solutions = new ArrayList<List<String>>();
//        int[] queens = new int[n];
//        Arrays.fill(queens, -1);
//        Set<Integer> columns = new HashSet<Integer>();
//
//        // 两个方向的对角线的
//        Set<Integer> diagonals1 = new HashSet<Integer>();
//        Set<Integer> diagonals2 = new HashSet<Integer>();
//
//        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
//        return solutions;
//    }
//    // 左对角线的数组 存放 行下标和列下标之差
//    public void backtrack(List<List<String>> res, int[] queues, int n, int start, Set<Integer> columns,
//                          Set<Integer> diagonals1,  Set<Integer> diagonals2){
//        if (start == n){
//            // 来到了最后一行 queues记录了每一行的下标数值
//            List<String> ans = getAns(queues);
//            res.add(ans);
//        }else {
//            // 该行从第一列开始
//            for (int i = 0; i < n; i++){
//                // 判断是否是同一列
//                if (columns.contains(i)){
//                    continue;
//                }
//
//                // 判断是否左对角线
//                int cel = start - i;
//                if (diagonals1.contains(cel)){
//                    continue;
//                }
//
//                // 判断是否右对角线
//                int cel2 = start + i;
//                if (diagonals2.contains(cel2)){
//                    continue;
//                }
//                queues[start] = i;
//                diagonals1.add(cel);
//                diagonals2.add(cel2);
//                columns.add(i);
//                backtrack(res, queues, n, start + 1, columns, diagonals1, diagonals2);
//
//
//                queues[start] = -1;
//
//                columns.remove(i);
//                diagonals1.remove(cel);
//                diagonals2.remove(cel2);
//            }
//
//        }
//
//
//    }
//    public List<String> getAns(int[] queues){
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < queues.length; i++) {
//            StringBuilder res = new StringBuilder();
//            int tmp = 0;
//            while (tmp != queues[i]){
//                res.append('.');
//                tmp++;
//            }
//            res.append('Q');
//            tmp++;
//            while (tmp < queues.length){
//                res.append('.');
//                tmp++;
//            }
//            list.add(res.toString());
//        }
//        return list;
//    }


//
//    public List<List<String>> solveNQueens(int n) {
//        int[] queens = new int[n];
//        Arrays.fill(queens, -1);
//        List<List<String>> solutions = new ArrayList<List<String>>();
//        solve(solutions, queens, n, 0, 0, 0, 0);
//        return solutions;
//    }
//
//    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
//        if (row == n) {
//            List<String> board = generateBoard(queens, n);
//            solutions.add(board);
//        } else {
//            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
//            while (availablePositions != 0) {
//                int position = availablePositions & (-availablePositions);
//                availablePositions = availablePositions & (availablePositions - 1);
//                int column = Integer.bitCount(position - 1);
//                queens[row] = column;
//                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
//                queens[row] = -1;
//            }
//        }
//    }
//
//    public List<String> generateBoard(int[] queens, int n) {
//        List<String> board = new ArrayList<String>();
//        for (int i = 0; i < n; i++) {
//            char[] row = new char[n];
//            Arrays.fill(row, '.');
//            row[queens[i]] = 'Q';
//            board.add(new String(row));
//        }
//        return board;
//    }



    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            // 计算是否还有空位
            // 2 ^ n - 1 &
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));

            //有1就代表有空位
            while (availablePositions != 0) {
                // 获取availavlePosition位置上最低位1的位置
                int position = availablePositions & (-availablePositions);


                // 将最低位置的1置为0
                availablePositions = availablePositions & (availablePositions - 1);

                int column = Integer.bitCount(position - 1);

                // 改行是第几个存放皇后
                queens[row] = column;

                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }





    public static void main(String[] args) {
        ML_0812 m = new ML_0812();
        List<List<String>> lists = m.solveNQueens(4);
        for (List<String> s : lists){
            for (String a : s){
                System.out.println(a);
            }
            System.out.println();
        }

        System.out.println(5 & 4);

    }

}







