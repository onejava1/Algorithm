package niuke;

import java.util.Scanner;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/6/14 22:07
 **/
public class CallSeven {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String[] s2 = s1.split(" ");
        int[] data = new int[s2.length];

    }
    // 先统计一共喊了多少次过
    // 一共有多少人
    // 7的倍数
    // 含有7需要喊过
    public int[] getAns(int[] data){
        // 需要统计最后一次过的时候的数字大小
        int sum = 0;
        for (int datum : data) {
            sum += datum;
        }
        int end = 7 * sum;
        //
        for(int i = 7; i < end; i++){
            int k = i % 7;

        }
        return null;
    }
}
