package leetcode.medium;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/15 18:06
 **/
public class L_746 {
    /**
     * 还可以优化 暂时不优化了
     * @param cost
     * @return
     */
    public int minCostClimbingStairs (int[] cost) {
        // write code here
        int[] res = new int[cost.length + 2];
        int c = cost.length - 1;
        while (c >= 0){
            res[c] = Math.min(res[c + 1], res[c + 2]) + cost[c];
            c--;
        }
        return res[0] > res[1] ? res[1] : res[0];
    }

    // recursion[i] = Math.min(cursion[i + 1], recursion[i + 2]) + cost[i]
    private int recursion(int[] cost, int i, int sum){
        if (i >= cost.length){
            return sum;
        }
        return Math.min(recursion(cost, i + 1, sum + cost[i]),
                recursion(cost, i + 2, sum + cost[i]));
    }

}
