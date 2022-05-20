package leetcode.weekilycompetion;

public class L_5994 {
    // 字串的长度必须为K 应该是滑动窗口
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int left = s.length() - k;
        int right = s.length() - 1;
        var help = new int[k];
        getpK(help, k);
        help[0] = power;
        int sum = 0;
        int index = left;
        String res = null;
        while (index != right + 1){
            sum += (s.charAt(left) - 'a' + 1) * help[index - left];
            index++;
        }
        if (sum % modulo == hashValue){
            res = s.substring(left, right + 1);
        }
        while (left >= 0){
            if (left - 1 > 0) {
                sum = (sum - s.charAt(left) - 'a' + 1) * power + s.charAt(left - 1);
                if (sum % modulo == hashValue){
                    res = s.substring(left, right + 1);
                }
            }else {
                break;
            }
            left--;
            right--;
        }
        return res;
    }
    private void getpK(int[] help, int power){
        for (int i = 1; i < help.length; i++) {
            help[i] = help[i - 1] * power;
        }
    }

    public static void main(String[] args) {
        L_5994 l_5994 = new L_5994();
        String leetcode = l_5994.subStrHash("mipcpqwbxihxblaplpfckvxtihonijhtezdnkjmmk",
                22,
                51,
                41, 9
                );
        System.out.println(leetcode);

    }
}
