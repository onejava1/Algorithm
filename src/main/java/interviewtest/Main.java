package interviewtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<List<Integer>> list = new ArrayList<>();
        int[] help = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> c = new ArrayList<>();
            int a = s.nextInt();
            int need = s.nextInt();
            help[i] = need;
            for (int i1 = 0; i1 < a; i1++){
                c.add(s.nextInt());
            }
            list.add(c);
        }

        for (int i = 0; i < list.size(); i++) {
            getTime(list.get(i), help[i]);
        }

    }

    public static void getTime(List<Integer> help, int m){
        for (int i = 0; i < help.size(); i++) {
            System.out.print(help.get(i) - m >= 0 ? help.get(i) - m : 0);
            System.out.print(" ");
        }
        System.out.println();
    }


}
