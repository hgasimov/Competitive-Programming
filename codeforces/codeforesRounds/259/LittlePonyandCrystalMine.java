//package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #259 (Div. 2), Problem A
 */
public class LittlePonyandCrystalMine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int mid = n/2;
        int lo = mid, hi = mid;
        for (int i = 0; i < mid; i++) {
            print(out, n, lo--, hi++);            
        }
            
        for (int i = mid; i < n; i++)
            print(out, n, lo++, hi--);

        out.flush();
    }
    
    private static void print(PrintWriter out, int n, int lo, int hi) {
        for (int i = 0; i < n; i++)
            if (lo <= i && i <= hi) 
                out.print('D');
            else 
                out.print('*');
        out.println();
    }
}
