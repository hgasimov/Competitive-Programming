package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #226 (Div. 2), Problem A
 */
public class BearandRaspberry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            c = in.nextInt();
        
        int prev = in.nextInt();
        int max = c;        
        for (int i = 1; i < n; i++) {
            int xi = in.nextInt();
            max = Math.max(max, prev - xi);
            prev = xi;
        }
        
        out.println(max - c);
        out.flush();
    }
}
