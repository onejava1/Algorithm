package interviewtest;

public class Bole3 {
    public int MatchString (String s, String t) {
        char[] shelp = new char[26];
        char[] thelp = new char[26];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            shelp[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            thelp[index]++;
        }

        for (int i = 0; i < 26; i++){
            if(thelp[i] != 0 && shelp[i] == 0){
                return 0;
            } else if (thelp[i] != 0 && shelp[i] != 0){
                if (shelp[i] < thelp[i]){
                    return 0;
                }
                int k = shelp[i] / thelp[i];
                res = Math.min(k, res);
            }
        }

        if (res == Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Bole3 b = new Bole3();
        System.out.println(b.MatchString("dogabcd", "dog"));
    }

}
