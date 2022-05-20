package leetcode.easy;

import java.util.HashSet;

public class L_804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] str = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(String word : words){
            StringBuilder s = new StringBuilder();
            int left = 0;
            while(left < word.length()){
                String ahlep = str[word.charAt(left++) - 'a'];
                s.append(ahlep);
            }
            set.add(s.toString());
        }
        return set.size();
    }

}
