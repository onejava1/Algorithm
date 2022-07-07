package classicalgorithm.Tree;

import java.util.Scanner;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/7/6 17:39
 **/
public class SegementTree {

    /**
     * 以一个例题来入门线段树
     * 给定一个数组，
     * 可以在某一个数字+x，也可以在任意的时候对一个数组的区间求和
     * 0位置不算
     */

    // 数组的最大数据是5 * 10 ^ 5 所以二叉树的存储个数就是 4 * n
    int[] f;

    // 数组的最大个数
    int[] a;
    /**
     *
     * @param k 在二叉树数组中的下标
     * @param l 线段数组的左端点
     * @param r 线段数组的右端点
     */
    public void buildTree(int k, int l, int r){
        // 采用递归建立树
        if (l == r){
            // l == r 代表着已经走到该线段的最底部 也就是叶子节点
            f[k] = a[l];
            return;
        }
        int mid = (l + r) >> 1;
        // 递归建立左子树
        buildTree(2 * k, l, mid);
        buildTree(2 * k + 1, mid + 1, r);
        // 建立好左右子树之后 得到本线段树的总和
        f[k] = f[2 * k] + f[2 * k + 1];
    }

    /**
     *
     * @param k 线段树数组的下标 都是从1开始的
     * @param l 线段数组的左端点 初始规定了的就是1
     * @param r 线段数组的右端点 初始规定了就是n
     * @param x 数字实际在数组的下标
     * @param y 实际数组x位置中的点需要被修改的数值
     */
    public void add(int k, int l, int r, int x, int y){
        f[k] += y;
        if (l == r){
            // 到达叶子节点了
            return;
        }
        int mid = (l + r) >> 1;
        if (x <= mid){
            // 去到线段数组的左子树区间
            add(k * 2, l, mid, x, y);
        }else {
            // 去到线段数组的右子树节点
            add(k * 2 + 1, mid + 1, r, x, y);
        }
    }

    /**
     *
     * @param k 树状数组的下标
     * @param l 默认是1
     * @param r 默认是n
     * @param s 在实际数组的左边下标
     * @param t 在实际数组的右边下标
     * @return
     */
    public int calculate(int k, int l, int r, int s, int t){
        // 当区间直接就匹配的时候
        if(l == s && r == t){
            return f[k];
        }
        int mid = (l + r) >> 1;
        // s - t 完全在左边的区间
        if (t <= mid){
            return calculate(k * 2, l, mid, s , t);
        }else if(s > mid){
            // 完全在右边的区间
            return calculate(k * 2 + 1, mid + 1, r, s , t);
        }else {
            // 出现了部分在左子树，部分在右子树的情况
            return calculate(k * 2, l, mid, s, mid) + calculate(k * 2 + 1, mid + 1, r, mid + 1, t);
        }
    }

    public static void main(String[] args) {
        init();
    }

    private static void init(){
        SegementTree segementTree = new SegementTree();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] numbers = new int[n + 1];
        for (int i = 1; i < numbers.length; i++){
            numbers[i] = s.nextInt();
        }
        int[][] operate = new int[m][3];
        for (int i = 0; i < m; i++){
            for (int k = 0; k < 3; k++) {
                operate[i][k] = s.nextInt();
            }
        }
        segementTree.a = numbers;
        segementTree.f = new int[4 * n + 1];
        // 建树
        segementTree.buildTree(1, 1, n);
        for (int i = 0; i < operate.length; i++) {
            if (operate[i][0] == 1){
                int numbersK = operate[i][1];
                segementTree.add(1, 1, n, operate[i][1],operate[i][2]);
            }else {
                System.out.println(segementTree.calculate(1, 1, n, operate[i][1], operate[i][2]));
            }
        }
//        测试数据
//        5 5
//        1 5 4 2 3
//        1 1 3
//        2 2 5
//        1 3 -1
//        1 4 2
//        2 1 4


    }


}
