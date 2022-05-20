package interviewtest;

public class FiveEight_3 {

    static int res = 0;
    // f(i)
    public int getCount (int m) {

        setap(1, m);
        return res;
    }

    public void setap(int i, int m){
        if (i == m){
            res++;
            return;
        }
        if (i > m){
            return;
        }
        if (i % 2 == 0){
            setap(i + 1, m);
            setap(i + 3, m);
        }else {
            setap(i + 1, m);
            setap(i + 2, m);
        }


    }

    public static void main(String[] args) {
        FiveEight_3 f = new FiveEight_3();
        System.out.println(f.getCount(3));
    }
}
