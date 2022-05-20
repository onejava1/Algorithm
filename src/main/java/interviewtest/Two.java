package interviewtest;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n ; i++){
            for (int k = i + 1; k <= n; k++){
                res.append(i);
                res.append(" ");
                res.append(k);
                res.append("\n");
            }
        }

        System.out.print(res.toString());

    }
}
