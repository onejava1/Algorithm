package leetcode.easy;

public class JLII_2 {
    public String addBinary(String a, String b) {
        int[] res = new int[a.length() > b.length() ? a.length() + 1 : b.length() + 1];
        int aright = a.length() - 1;
        int bright = b.length() - 1;
        int end = res.length - 1;
        StringBuilder answer = new StringBuilder();
        int k = res.length - 1;
        while (aright >= 0 && bright >= 0){
            int ac = a.charAt(aright) - '0';
            int bc = b.charAt(bright) - '0';
            int r = ac + bc;
            if (res[k] == 0) {
                if (r == 2) {
                    res[k - 1] += 1;
                }
                if (r == 1){
                    res[k] = 1;
                }
            }else if (res[k] == 1){
                if (r == 2) {
                    res[k - 1] += 1;
                }
                if (r == 1){
                    res[k] = 0;
                    res[k - 1] += 1;
                }
            }
            aright--;
            bright--;
            k--;
        }
        while (aright >= 0){
            int ac = a.charAt(aright) - '0' + res[k];
            if (ac == 2){
                res[k - 1] = 1;
                res[k] = 0;
            }else if (ac == 1){
                res[k] = 1;
            }
            aright--;
            k--;
        }
        while (bright >= 0){
            int bc = b.charAt(bright) - '0' + res[k];
            if (bc == 2){
                res[k - 1] = 1;
                res[k] = 0;
            }else if (bc == 1){
                res[k] = 1;
            }
            bright--;
            k--;
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0){
                continue;
            }else {
                end = i;
                break;
            }
        }
        for (int i = end; i < res.length; i++) {
            answer.append(res[i]);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        JLII_2 l = new JLII_2();
        String a = l.addBinary("100", "110010");
        System.out.println(a);
    }
}
