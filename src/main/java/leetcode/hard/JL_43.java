package leetcode.hard;

public class JL_43 {
    public int countDigitOne(int n) {
        int k = 1;
        int res = 0;
        while (k <= n){
            //
            int a = (n % (k * 10)) - k + 1;
            int b = a < 0 ? 0 : a >= k ? k : a;
            int c = (n / (k * 10)) * k;
            res += c + b;
            k *= 10;
        }
        return res;
    }

    public int countDigitOne1(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        JL_43 l = new JL_43();
        System.out.println(l.countDigitOne1(1410065408));
    }
}
