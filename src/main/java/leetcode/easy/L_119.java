package leetcode.easy;

import leetcode.medium.L_11;

import java.util.ArrayList;
import java.util.List;

public class L_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        List<Integer> res = null;
        for(int i = 2; i <= rowIndex + 1; i++){
            res = new ArrayList<Integer>(i);
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i - 1){
                    res.add(1);
                } else {
                    int now = list.get(j) + list.get(j - 1);
                    res.add(now);
                }
            }
            list = res;
        }
        return list;
    }

    public static void main(String[] args) {
        L_119 l = new L_119();
        l.getRow(3);


    }
}
