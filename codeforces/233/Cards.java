package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #233 (Div. 2), Problem C
 */
public class Cards {
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        long a = in.nextLong();
        long b = in.nextLong();
        
        long max = sqr(a) - sqr(b);
        long max_i = 0;
        for (long i = 1; i <= a; i++) {
            long k = sqr(a-i+1) + quick_calc(i, b) - 1;
            if (k > max) {
                max = k;
                max_i = i;
            }
        }                      
        
        //out.println(max_i);
        out.println(max);
        build(out, a, b, max_i);
                
        out.flush();
    }
    
    private static void build(PrintWriter out, long a, long b, long max_i) { 
        long m;
        if (max_i > 0) {
            m = b / (max_i + 1);

            print(out, 'x', m);
            print(out, 'o', a - max_i + 1);

            a -= a - max_i + 1;
            b -= m;
        }
        
        while (a > 0) {
            m = b / (a+1);
            a--;
            b -= m;

            print(out, 'x', m);
            print(out, 'o', 1);
        }
            
        print(out, 'x', b);
        out.println();
    }
    
    private static long quick_calc(long a, long b) {
        long m = b / (a+1);
        
        long c2 = b - m * (a + 1);
        long c1 = a + 1 - c2;
        
        return a - c1 * sqr(m) - c2 * sqr(m+1); 
    }
    
    private static void print(PrintWriter out, char c, long a) {
        for (int i = 0; i < a; i++) out.print(c);
    }
    
    private static long sqr(long l) { return l*l; }    
}
