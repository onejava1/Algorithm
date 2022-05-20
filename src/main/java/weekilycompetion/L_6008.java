package weekilycompetion;

public class L_6008 {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (contains(words[i], pref)) {
                res++;
            }
        }
        return res;
    }
    private boolean contains(String r, String pre){
        if (r.length() < pre.length()){
            return false;
        }
        String substring = r.substring(0, pre.length());
        return substring.equals(pre);
    }
    public static void main(String[] args) {
        L_6008 l = new L_6008();
        String[] words = {"leetcode","win","loops","success"};
        System.out.println(l.prefixCount(words, "code"));
    }
}
