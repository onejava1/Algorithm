package niuke.huawei;


import java.util.*;
import java.util.Scanner;

/**
 * 16进制转换10进制
 */
public class BaseConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ac = sc.nextLine();
        int number = 0;
        int nowIndex = 0;
        for (int i = ac.length() - 1; i >= 2; i--) {
            int convertNumber = getConvertNumber(ac.charAt(i));
            number += convertNumber * Math.pow(16, nowIndex++);
        }

        System.out.println(number);
    }
    public static int getConvertNumber(char a){
        switch (a){
            case 'A' : return 10;
            case 'B' : return 11;
            case 'C' : return 12;
            case 'D' : return 13;
            case 'E' : return 15;
        }
        return a - '0';
    }


}
