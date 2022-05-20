package classicalgorithm.other;

public class Kmp {


    public int getIndexof(String match, String isMatched){
        if (match == null || isMatched == null || isMatched.length() < 1 || isMatched.length() > match.length()){
            return -1;
        }
        char[] str1 = match.toCharArray();
        char[] str2 = isMatched.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < match.length() && i2 < isMatched.length()){
            if (str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if (i2 == 0){
                //当前I1结束 下一个尝试下
                // next[i2] == -1代表 i2位置重新开始 不可以往前跳
                i1++;
            }else {
                // 可以加速 //加速
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private int[] getNextArray(char[] ms){
        if (ms.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        // cn该位置的字符的长度
        int cn = 0;
        while (i < ms.length){
            // i-1位置和next[i-1]位置的字符相同
            if (ms[i - 1] == ms[cn]){
                next[i++] = ++cn;
            }else if (cn > 0){
            //  如果不等 cn一直网上去比对 直到某个位置i-1等于 i-1
                cn = next[cn];
            }else {
                //如果cn = 0了 那么解结束了 一直找不到只能重新开始 优化也无用了
//                cn = 0
                next[i++] = 0;
            }
        }
        return next;
    }
}
