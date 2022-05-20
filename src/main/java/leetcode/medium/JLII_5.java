package leetcode.medium;

/**
 * 单词长度的最大乘积
 */
public class JLII_5 {
    public int maxProduct(String[] words) {
        int max = 0;
        int[][] help = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int i1 = 0; i1 < words[i].length(); i1++) {
                int index = words[i].charAt(i1) - 'a';
                help[i][index]++;
            }
        }

        for (int i = 0; i < help.length; i++) {
            for (int i1 = i + 1; i1 < help.length; i1++) {
                int times = 0;
                int c = 0;
                for (int ic = 0; ic <= 25; ic++){
                    if (help[i][ic] == 0 || help[i1][ic] == 0) {
                           times += help[i][ic] +  help[i1][ic];
                    }else if (help[i][ic] != 0 && help[i1][ic] != 0){
                        c = 0;
                        times = 0;
                        break;
                    }
                    if (help[i][ic] != 0){
                        c += help[i][ic];
                    }
                }
                max = Math.max(max, c * (times - c));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = {"a","aa","aaa","aaaa"};
        JLII_5 j = new JLII_5();
        System.out.println(j.maxProduct(words));
    }
}
