package leetcode.weekilycompetion;

public class L_2156 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long[] pows = new long[k];
        pows[0] = 1;
        for (int i = 1; i < k; i++) {
            //
            pows[i] = pows[i - 1] * power % modulo;
        }

        for (int i = 0; i <= s.length() - k; i++) {
            String subStr = s.substring(i, i + k);
            if (val(subStr, pows, modulo) == hashValue) {
                return subStr;
            }
        }
        return "";
    }

    private int val(String subStr, long[] pows, int modulo) {
        long res = 0;
        for (int i = 0; i < subStr.length(); i++) {
            res += (subStr.charAt(i) - 'a' + 1) * pows[i];
            res %= modulo;
        }
        return (int) (res % modulo);
    }

    public String subStrHash1(String s, int power, int modulo, int k, int hashValue) {
        long[] pows = new long[k];
        pows[0] = 1;
        for (int i = 1; i < k; i++) {
            pows[i] = (pows[i - 1] * (power % modulo)) % modulo;
        }

        for (int i = 0; i <= s.length() - k; i++) {
            String subStr = s.substring(i, i + k);
            if (val(subStr, pows, modulo) == hashValue) {
                return subStr;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        L_2156 l = new L_2156();
        String leetcode = l.subStrHash("leetcode",
                7,
                20,
                2,
                0
        );
        System.out.println(leetcode);
    }
}
