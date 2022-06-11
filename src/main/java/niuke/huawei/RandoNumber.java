package niuke.huawei;

import java.util.*;


public class RandoNumber {

    /**
     * 找到一个不用TreeMap的做法 应该是
     * @param args
     */
    public static void main(String[] args){
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        List<Integer> list = new ArrayList<>(a);
        while(a != 0){
            int tmp = sc.nextInt();
            map.put(tmp, 0);
        }

        map.forEach((key, value) -> {
            System.out.println(key);
        });
    }
}
