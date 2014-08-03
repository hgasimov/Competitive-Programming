package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #248 (Div. 2), Problem A
 */
public class KitaharaHarukisGift {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int n100 = 0;
        for (int i = 0; i < n; i++)
            if (in.nextInt() == 100) n100++;


        if(n100 % 2 == 0) {
           if (n100 > 0) {
               out.println("YES");
           }
           else {
               out.println((n - n100) % 2 == 0 ? "YES" : "NO");
           }
        }
        else {
            out.println("NO");
        }
        out.flush();
    }
}