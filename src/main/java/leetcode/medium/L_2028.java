package leetcode.medium;

//  找出缺失的观察数据
public class L_2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int sum = (n + rolls.length) * mean;
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum < n || sum > 6 * n){
            return res;
        }
        int k = sum / n;
        int c = sum % n;
        int index = 0;
        while (index < n){
            if (index < c) {
                res[index++] = k + 1;
            }else {
                res[index++] = k;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        L_2028 l = new L_2028();
        int[] nums = {3, 2, 4, 3};
        System.out.println(l.missingRolls(nums, 4, 2));
    }


}
