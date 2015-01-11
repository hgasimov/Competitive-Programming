package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #232 (Div. 2), Problem A
 */
public class OnSegmentsOwnPoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int lo = in.nextInt(),
            hi = in.nextInt();
        
        boolean[] occupied = new boolean[hi];
        int nOccup = 0;
        for (int i = 1; i < n; i++) {
            int left = in.nextInt(),
                right = in.nextInt();
            
            for (int j = Math.max(left, lo); j < right; j++) {
                if (j >= hi) break;
                if (!occupied[j]) {
                    occupied[j] = true;
                    nOccup++;
                }
            }
        }
        
        out.println(hi - lo - nOccup);
        out.flush();
    }
}
