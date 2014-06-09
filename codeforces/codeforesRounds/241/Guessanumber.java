package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #241 (Div. 2), Problem A
 */
public class Guessanumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = Integer.parseInt(in.nextLine().trim());
        int lo = -2000000000,
            hi = 2000000000;
        boolean pos = true;
        
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().trim().split(" ");
            int x = Integer.parseInt(line[1]);
            
            if (line[0].equals(">=")) {
                line[0] = ">";
                x--;
            }
            
            if (line[0].equals("<=")) {
                line[0] = "<";
                x++;
            }
            
            boolean less = line[0].equals("<");
            
            if (line[2].equals("N")) {
                x = less ? x-1 : x+1;
                less = !less;
            }
            
            if (less) {
                hi = Math.min(hi, x-1);
            }
            else {
                lo = Math.max(lo, x+1);
            }
            
            if (lo > hi) {pos = false; break;}
        }
        
        out.println(pos ? lo : "Impossible");
        out.flush();
    }
}
