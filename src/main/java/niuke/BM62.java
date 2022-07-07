package niuke;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/15 17:40
 **/
public class BM62 {

    public int Fibonacci(int n) {
        if(n < 3){
            return 1;

        }        int[] help = new int[4];
        help[1] = 1;
        help[2] = 1;
        while (n != 2){
            help[3] = help[1] + help[2];
            if(n - 1 == 2){
                return help[3];
            }
            help[1] = help[2];
            help[2] = help[3];
            n--;
        }
        return -1;
    }

    public static void main(String[] args) {
        BM62 b = new BM62();
        System.out.println(b.Fibonacci(7));
    }
}
