package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #244 (Div. 2), Problem A
 */
public class PoliceRecruits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int p = 0;
        int u = 0;
        for (int i = 0; i < n; i++) {
            p += in.nextInt();
            if (p < 0) {
                p = 0;
                u++;
            }
            
        }

        out.println(u);
        out.flush();
    }
}
