package leetcode.weekilycompetion;

public class L_6012 {
    public int countEven(int num) {
        int length = 0;
        int tmp = num;
        while (tmp != 0){
            tmp /= 10;
            length++;
        }
        if (length == 1){
            return num / 2;
        }
        for (int i = 1; i < length; i++){
            if (length % 2 == 0){
                // 双数长度 全为奇数 全为偶数


            }else {
                // 单数长度
            }
        }
        return -1;

    }
}
