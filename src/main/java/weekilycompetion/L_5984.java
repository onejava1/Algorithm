package weekilycompetion;

import java.util.ArrayList;
import java.util.Arrays;

public class L_5984 {

    public int minimumSum(int num) {
        int[] tmp = new int[4];
        int c = 0;
        while (num != 0) {
            int t = num % 10;
            tmp[c++] = t;
            num /= 10;
        }
        Arrays.sort(tmp);
        return (tmp[0] + tmp[1]) * 10 + tmp[2] + tmp[3];

    }

    public static void main(String[] args) {
        L_5984 l = new L_5984();
        System.out.println(l.minimumSum(5787));
    }
}
