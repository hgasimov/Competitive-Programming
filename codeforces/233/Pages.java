package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #233 (Div. 2), Problem A
 */
public class Pages {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int p = in.nextInt();
        int k = in.nextInt();
        
        if (p - k > 1) System.out.print("<< ");
        for (int i = 0; i <= 2*k; i++) {
            int c = p - k + i;
            if (c >= 1 && c <= n) {
                if (c == p) out.print("(" + c + ") ");
                else out.print(c + " ");
            }
        }
        
        if (p + k < n) out.print(">>");        
        out.flush();        
    }
}
