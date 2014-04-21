package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 *  Codeforces Round #236 (Div. 2), Problem C
 */
public class SearchingforGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            int n = in.nextInt(),
                p = in.nextInt();

            int total = 2*n + p;
            int con = 0;
            main:
            for (int i = 1; i < n; i++)
                for (int j = i+1; j <= n; j++) {
                    out.println(i + " " + j);
                    con++;
                    if (con == total) break main;
                }
        }
        
        out.flush();
    }
}
