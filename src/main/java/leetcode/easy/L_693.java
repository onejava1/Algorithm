package leetcode.easy;

public class L_693 {
    public boolean hasAlternatingBits(int n) {
            int pre = n & 1;
            while(n != 0){
                n = n >> 1;
                if(pre == (n & 1)){
                    return false;
                }
                pre = n & 1;
            }
            return true;
    }

}
