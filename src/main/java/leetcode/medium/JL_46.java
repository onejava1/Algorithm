package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JL_46 {
    public int translateNum(int num) {
        var number =  new ArrayList<Integer>();
        while (num != 0){
            var c = num % 10;
            number.add(c);
            num /= 10;
        }
        Collections.reverse(number);
        int i = backTracking(number, 0);
        return i;
    }
    private int backTracking(List<Integer> number, int i){
        if (i > number.size() - 1){
            // 直接到达最后一个
            return 1;
        }
        int sum = 0;
        if (i < number.size() - 1){
            if (number.get(i) == 0){
                sum += backTracking(number, i + 1);
            }
            else {
                int a = number.get(i) * 10 + number.get(i + 1);
                if (a <= 25) {
                sum += backTracking(number, i + 2);
            }
                sum += backTracking(number, i + 1);
            }
        }else {
            sum += backTracking(number, i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        JL_46 l = new JL_46();
        System.out.println(l.translateNum(506));
    }

}
