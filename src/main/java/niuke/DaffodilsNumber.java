package niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *
 * @author huang.fei
 * @version 1.0
 * @description 求解水仙花数
 * @date 2022/6/13 9:29
 **/
public class DaffodilsNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bufferedReader.readLine());
        int m = Integer.valueOf(bufferedReader.readLine());
        System.out.println(daffodilsCount(n, m));
    }

    public static int daffodilsCount(int n, int m){
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n);
        int times = -1;
        for (int i = start; i <= end; i++){
            if(daffodils(i, n)){
                times++;
            }
            if (times == m){
                return i;
            }
        }
        return -1;
    }


    // 是否是水仙花数字
    public static boolean daffodils(Integer number, Integer n){
        int tmp = number;
        int sum = 0;
        while (tmp != 0){
            int c = tmp % 10;
            sum += Math.pow(c, n);
            tmp /= 10;
        }
        return sum == number;
    }

}
