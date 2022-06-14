package niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author huang.fei
 * @version 1.0
 * @description 组成的最大卡片 每张数字在6位数字以内
 * @date 2022/6/14 21:19
 **/
public class CardComposeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] numbers = s.split(",");
        // 特殊的排序
        // numbers[1] + numbers[2] > numbers[2] + number[3] 具有传递性
        // 就可以确定numbers[1] 一定在第一个位置
        List<String> list = new ArrayList<String>(List.of(numbers));
        Collections.sort(list, new Comparator<String>(){
            // 从大到小
            @Override
            public int compare(String i, String c) {
                int i1 = i.length();
                int i2 = c.length();
                for (int s1 = 0, s2 = 0; s1 < i1 && s2 < i2; s1++, s2++){
                    int k = i.charAt(s1) - c.charAt(s2);
                    if(k > 0){
                        return -1;
                    }else if (k < 0){
                        return 1;
                    }else {
                        continue;
                    }
                }

                return i1 < i2 ? -1 : 1;
            }
        });
        for (String s1 : list) {
            System.out.println(s1);
        }
    }




}
