package leetcode.medium;

//数值的整数次方
//简单点来说 先判断 n 是 2的多少次方
public class JL_16 {

    // 快速幂是对次方就行快速幂
    public double myPow(double x, int n) {
      long b = n;
      double res = 1;
      if (b < 0){
          b = -b;
          x = 1 / x;
      }
      while (b > 0){
          if (b % 2 != 0){
              res *= x;
          }
          x *= x;
          b >>= 1;
      }
      return res;
    }


    public static void main(String[] args) {
        JL_16 jl_16 = new JL_16();


        double v = jl_16.myPow(2, 10);
        System.out.println(v);

    }

}
