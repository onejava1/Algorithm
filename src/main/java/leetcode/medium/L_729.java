package leetcode.medium;


import java.util.List;
import java.util.TreeSet;

/**
 * @author huang.fei
 * @version 1.0
 * @description
 * @date 2022/7/5 21:32
 **/
public class L_729 {

    TreeSet<int[]> set;
    public L_729() {
        set = new TreeSet<int[]>();
    }

    public boolean book(int start, int end) {
        return false;
    }

    public int search(List<Integer> list, Integer tmp){
        int left = 0;
        int right = list.size() - 1;
        if (tmp < list.get(0)){
            return 0;
        }
        if (tmp > list.get(list.size() - 1)){
            return list.size() - 1;
        }
        while (left < right){
            int mid = (left + right) >> 1;
            int midNumber = list.get(mid);
            if (midNumber < tmp){
                if (tmp < list.get(mid + 1)){
                    return left;
                }
                left = left + 1;
            }else if (midNumber == tmp){
                return -1;
            }else if (midNumber > tmp){
                if (tmp > list.get(mid - 1)){
                    return mid - 1;
                }
                right = right - 1;
            }
        }
        return -1;
    }

}
