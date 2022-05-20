package leetcode.easy;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class L_682 {

    public int calPoints(String[] ops) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for(String a : ops){
            if(a.equals("D")){
                int tmp = stack.peekFirst() * 2;
                res += tmp;
                if (stack.size() == 2) {
                    stack.removeLast();
                    stack.addFirst(tmp);
                }else {
                    stack.addFirst(tmp);
                }
            }else if(a.equals("+")){
                int need = stack.peekFirst() + stack.removeLast();
                stack.addFirst(need);
                res += need;

            }else if(a.equals("C")){
                int c = stack.removeFirst();
                res -= c;

            }else{
                Integer k = Integer.valueOf(a);
                res += k;
                if (stack.size() == 2){
                    stack.removeLast();
                    stack.addFirst(k);
                }else {
                    stack.addFirst(k);
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        L_682 l = new L_682();
        String[] ops = {"5","2","C","D","+"};
        BigDecimal b = new BigDecimal(1);
        BigDecimal ba = new BigDecimal(1);
        System.out.println(l.calPoints(ops));
    }
}
