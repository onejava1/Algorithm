package leetcode.easy;

public class JLII_18 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else {
                Character l = Character.toLowerCase(s.charAt(left++));
                Character r = Character.toLowerCase(s.charAt(right--));
                if (!l.equals(r)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
            } else {
                char char1 = Character.toLowerCase(s.charAt(left++));
                char char2 = Character.toLowerCase(s.charAt(right--));
                if (char1 != char2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JLII_18 l = new JLII_18();
        System.out.println(l.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
