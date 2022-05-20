package interviewtest;

import java.util.ArrayList;
import java.util.List;

public class FiveEight_2 {

    public ArrayList<ArrayList<Integer>> process (int[] allScoreArray, int examCount, int lastScore) {
//        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
//        List<Integer> arrayList = ArrayList.of(3, 5, 4, 8, 10, 6);
//
        return null;
    }
//    public int[] ok(int use, int[] a, ArrayList<Integer> res){
//        if (use == 0){
//
//        }
//
//
//
//    }



    public static void main(String[] args) {
        FiveEight_2 f = new FiveEight_2();
        int[] c = {3, 4, 5,6,7,8,9,10};
        ArrayList<ArrayList<Integer>> process = f.process(c, 6, 6);
        for (List<Integer> k : process){
            System.out.println(c);
        }
    }

}
