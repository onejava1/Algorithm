package leetcode.weekilycompetion;

import javax.swing.plaf.basic.BasicEditorPaneUI;
import java.util.Arrays;

public class L_6006 {
    public long minimumRemoval(int[] beans) {
        long min = Long.MAX_VALUE;
        long pre = 0L;
        Arrays.sort(beans);
        for (int i = 0; i <= beans.length - 1; i++) {
            pre += beans[i];
        }
        min = Math.min(min, res(0, pre, beans));
        for (int i = 1; i < beans.length; i++) {
            if (beans[i] == beans[i - 1]){
                continue;
            }else {
                min = Math.min(min, res(i, pre, beans));
            }
        }
        return min;
    }

    public long res(int c, long helpc, int[] beans){
        long res = helpc - (long)beans[c] * (beans.length - c);
        return res;
    }


    public long minimumRemoval1(int[] beans) {
        Arrays.sort(beans);

        long ans = Long.MAX_VALUE, total = 0L;

        for(int bean : beans){
            total += bean;
        }

        for(int i = 0; i < beans.length; i++){
            long take = total - (long)beans[i] * (beans.length - i);
            ans = Math.min(ans, take);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] c = {2,10,3, 2};
        L_6006 l = new L_6006();
        System.out.println(l.minimumRemoval(c));
    }
}
