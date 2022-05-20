package weekilycompetion;

import java.util.PriorityQueue;

public class L_2165 {
    public long smallestNumber(long num) {
        PriorityQueue<Integer> help = null;
        long res = 0;
        boolean a = num > 0;
        if (num > 0){
            // 小根堆
            help = new PriorityQueue<>();
        }else {
            // 大根堆
            help = new PriorityQueue<>((x, y)->{
                return y - x;
            });
        }
        while (num != 0){
            int c = (int) (num % 10);
            help.add(c);
            c /= 10;
        }
        if (!a) {
            while (!help.isEmpty()) {
                Integer poll = help.poll();
                res = res * 10 + poll;
            }
            return  - res;
        }else {
            int ZeroTimes = 0;
            while (!help.isEmpty()) {
                Integer poll = help.poll();
                if (poll == 0){
                    continue;
                }else {
                    res = res * 10 + poll;
                }
            }
            double pow = Math.pow(10, ZeroTimes);
            res *= pow;
            return res;
        }
    }

    public static void main(String[] args) {
        L_2165 l = new L_2165();
        System.out.println(l.smallestNumber(310));
    }
}
