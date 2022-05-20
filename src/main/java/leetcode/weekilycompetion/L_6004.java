package leetcode.weekilycompetion;

public class L_6004 {
    public int countOperations(int num1, int num2) {
        int times = 0;
        while (num1 != 0 && num2 != 0){
           if (num1 > num2){
               num1 -= num2;
           }else {
               num2 -= num1;
           }
           times++;
        }
        return times;
    }

    public static void main(String[] args) {
        L_6004 l = new L_6004();
        System.out.println(l.countOperations(10, 10));
    }

}
