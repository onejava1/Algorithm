package leetcode.easy;

public class JLII_19 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] k = s.toCharArray();
        while(left < right){
            if(k[left] == k[right]){
                left++;
                right--;
            }else{
                // 删除左边是否还能构成
                return isVaild(k, left + 1, right) || isVaild(k, left, right - 1);
            }
        }
        return true;
    }

    public boolean isVaild(char[] ac, int left, int right){
        while(left < right){
            if(ac[left] == ac[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        JLII_19 j = new JLII_19();
        System.out.println(j.validPalindrome("cupuufxo oxfuupucu"));

    }

}
