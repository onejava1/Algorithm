package leetcode.easy;

//KMP算法
public class L_28 {

    public int strStr(String longer, String subsequence) {
        if (longer == null || subsequence == null || subsequence.length() < 1 || longer.length() < subsequence.length())        {
            if(subsequence.length() == 0){
                return 0;
            }
            return -1;
        }
        char[] str1 = longer.toCharArray();
        char[] str2 = subsequence.toCharArray();
        // 记录大字符串的
        int i1 = 0;
        // 记录小字符串的
        int i2 = 0;
        int[] next = getNextArray(str2);

        // kmp算法最精髓的实现
        while (i1 < str1.length && i2 < str2.length){
            if (str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if (i2 == 0){
                //说明没有前缀和后缀的匹配
                i1 ++;
            }else {
                i2 = next[i2];
            }
        }
        // 跳出循环就是i1越界或者i2越界
        // i2越界代表找出来了第一个匹配的字符串
        return i2 == str2.length ? i1 - i2: -1;
    }


    // 得到辅助数组
    private  int[] getNextArray(char[] str){
        if (str.length == 1){
            return new int[]{-1};
        }

        int[] help = new int[str.length];
        // 初始的
        help[0] = -1;
        help[1] = 0;

        int pose = 2;
        int cn = 0;
        // help[i] <= help[i - 1] + 1
        while (pose < str.length){
            if (str[pose - 1] == str[cn]){
                help[pose++] = ++cn;
            }else if (cn > 0){
                cn = help[cn];
            }else {
                help[pose++] = 0;
            }
        }
        return help;
    }

    public static void main(String[] args) {
        L_28 l_28 = new L_28();
        System.out.println(l_28.strStr("",
                ""));
    }
}
