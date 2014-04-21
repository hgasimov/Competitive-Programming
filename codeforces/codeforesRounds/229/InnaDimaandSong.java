//package codeforces;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * Codeforces Round #229 (Div. 2)
 */
public class InnaDimaandSong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        long[] a = readArray(in, n);
        long[] b = readArray(in, n);
        
        BigInteger joy = BigInteger.ZERO;
        for (int i = 0; i < n; i++)
            if (b[i] > 1 && 2*a[i] >= b[i]) {
                long xi = b[i]/2;
                long yi = b[i] - xi;
                joy = joy.add(BigInteger.valueOf(xi * yi));                
            }
            else {
                joy = joy.subtract(BigInteger.ONE);
            }
        
        out.println(joy.toString());
        out.flush();
    }
    
    private static long[] readArray(Scanner in, int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
}
