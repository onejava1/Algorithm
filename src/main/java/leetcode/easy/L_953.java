package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class L_953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++){
            for(int first = 0, seconde = 0; first < words[i].length()
                    && seconde < words[i + 1].length(); first++, seconde++){
                int firstCharacter = map.get(words[i].charAt(first));
                int secondeCharacter = map.get(words[i +1].charAt(seconde));
                if(firstCharacter > secondeCharacter){
                    return false;
                }else if (firstCharacter == secondeCharacter){
                    if(first == words[i].length() - 1 || seconde == words[i + 1].length() - 1){
                        // 下一个越界了
                       if(words[i].length() >= words[i + 1].length()){
                           return false;
                       }
                    }
                }else {
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        retry:
        for(int i = 0; i <= 5; i++){
            System.out.println(i);
            for (int c = 0; c <= i; c++){
                if(c == 2){
                    // 直接跳出两重循环 其他的都与没用
                    break retry;
                }
            }
//            System.out.println(i);
        }
    }

}
