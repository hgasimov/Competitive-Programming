package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #240 (Div. 2), Problem B
 */
public class MashmokhandTokens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        long a = in.nextLong(),
             b = in.nextLong();
        
        for (int i = 0; i < n; i++) {
            long xi = in.nextLong();
            long wa = xi * a;
            
            if (wa < b) {
                out.print(xi + " ");
            }
            else {
                out.print((wa % b) / a);
                out.print(" ");
            }
        }
        
        out.flush();
    }
}
