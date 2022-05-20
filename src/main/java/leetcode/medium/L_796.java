package leetcode.medium;

public class L_796 {
    public boolean rotateString(String s, String goal) {
        if(s == null || goal == null || 2 * s.length() != goal.length()){
            return false;
        }

        String r = s + s;
        char[] shelp = r.toCharArray();
        char[] ghelp = goal.toCharArray();
        int[] nextArr = getNextArr(goal);
        int sleft = 0;
        int gleft = 0;
        while(sleft < r.length() && gleft < goal.length()){
            if(shelp[sleft] == ghelp[gleft]){
                sleft++;
                gleft++;
            }else if(gleft == 0){
                // 不可以加速
                sleft++;
            }else{
                // 加速的过程
                gleft = nextArr[gleft];
            }
        }

        return gleft == goal.length() ? true : false;
    }

    // kmp算法
    private int[] getNextArr(String goal){
        if(goal.length() == 1){
            return new int[]{-1};
        }
        int[] nextArr = new int[goal.length()];
        char[] tmp = goal.toCharArray();
        nextArr[0] = -1;
        nextArr[1] = 0;
        int i = 2;
        int index = 0;
        while(i < goal.length()){
            if(tmp[i - 1] == tmp[index]){
                nextArr[i++] = ++index;
            }else if(index > 0){
                // 还有加速的可能性
                index = nextArr[index];
            }else if(index == 0){
                // 走到第一个去了都没匹配 本身这个位置是0 去下一个位置
                i++;
            }
        }
        return nextArr;
    }

    public static void main(String[] args) {
        L_796 l = new L_796();
        System.out.println(l.rotateString("aa", "a"));
    }

}
