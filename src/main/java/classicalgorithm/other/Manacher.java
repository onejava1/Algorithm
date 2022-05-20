package classicalgorithm.other;



public class Manacher {

//
    // 返回回文半径最长的哪一个
    public  int maxLength(String arr){
        if (arr == null || arr.length() <= 1){
            return arr == null ? 0 : 1;
        }
        char[] chars = manacherString(arr);
        // 回文半径数组
        int[] help = new int[chars.length];
        // 最大回文有边界
        int c = -1;
        // 最大回文右边界的多下一个位置
        int r = -1;

        // 扩容的最大数值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < help.length; i++){
//            i在R外直接不用验证的区域是1
//            2 i在R内
//            2.1 如果 i'内 至少可以不用验证的区域就是那么大
            help[i] = r > i ? Math.min(help[2 * c - i], r - i) : 1;

            // 然后从不用开始验证的区域开始检验是否可以取得更大的回文半径数值
            while (i + help[i] < chars.length && i - help[i] > -1){
                if (chars[i + help[i]] == chars[i - help[i]]){
                    help[i]++;
                }else {
                    break;
                }
            }

            // 更新I和R
            if(i + help[i] > r){
                r = i + help[i];
                c = i;
            }
            max = Math.max(max, help[i]);
        }
        // 最大回文的长度
        return max - 1;
    }


    // 将string替换成为特殊字符串只能是奇数
    private char[] manacherString(String arr){
        char[] chars = arr.toCharArray();
        char[] help = new char[arr.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i < help.length; i++) {
            // 特殊字符的位置只有可能在数组的偶数位置
            help[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return help;
    }

    public static void main(String[] args) {
        Manacher m = new Manacher();

        System.out.println(m.maxLength("121111"));
    }
}
