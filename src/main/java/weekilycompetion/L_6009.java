package weekilycompetion;

public class L_6009 {

    public int minSteps(String s, String t) {
        int res = 0;
        int[] shelp = new int[26];
        int[] thelp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            shelp[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            thelp[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            res += Math.abs(shelp[i] - thelp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        L_6009 l = new L_6009();
        System.out.println(l.minSteps("leetcode", "coats"));
    }

}
