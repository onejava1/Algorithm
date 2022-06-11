package niuke.huawei;

import java.util.*;

public class qishui {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        for(;;){
            int a = sc.nextInt();

            if(a == 0){
                break;
            }
            list.add(a);
        }
        List<Integer> l = new ArrayList<Integer>();
        for(Integer a : list){
            int c = need(a, 0);
            l.add(c);
        }
        for(Integer c : l){
            System.out.println(c);
        }
    }

    public static int need(int boottle, int drink){
        if(boottle < 3){
            return boottle == 2 ? drink + 1 : drink;
        }
        int a = boottle / 3;
        int c = boottle % 3;
        return need(a + c, drink + a);
    }

}
