package leetcode.medium;

public class L_7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            int a = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && a > 7)){
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && a < -8)){
                return 0;
            }

            res = res * 10 + a;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(-21 / 10 + " " + -21 % 10);
    }




}
