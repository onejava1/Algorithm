package leetcode.medium;

public class JL_44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 这种比较好理解
        if (n < digit){
            return Long.toString(start).charAt(n - 1) - '0';
        }
        long num = start + (n - digit) / digit;
        int odd = (n - digit) % digit;
        if (odd == 0){
            return Long.toString(num).charAt(digit - 1) - '0';
        }else {
            long c = num + 1;
            return Long.toString(c).charAt(odd - 1) - '0';
        }
    }

    public static void main(String[] args) {
        JL_44 jl_44 = new JL_44();
        int nthDigit = jl_44.findNthDigit(10);
        System.out.println(nthDigit);

    }
}
