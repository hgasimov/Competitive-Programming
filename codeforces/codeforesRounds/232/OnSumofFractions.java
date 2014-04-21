package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #232 (Div. 2), Problem D
 */
public class OnSumofFractions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int t = in.nextInt();
        
        while (t-- > 0) {
            long n = in.nextLong();
            long vn = v(n),
                 un = u(n);
            
            long num = vn*un + 2*n - 2*(un + vn) + 2; // numerator
            long den = 2 * un * vn; // denominator
            long gcd = gcd(num, den); 
            num /= gcd;
            den /= gcd;
            out.println(num + "/" + den);
        }
        
        out.flush();
    }
    
    private static boolean isPrime(long x) {
        if (x < 2) return false;
        if (x == 2) return true;
        long max = (long) Math.sqrt(x);
        for (long i = 2; i <= max; i++)
            if (x % i == 0) return false;
        return true;
    }
    
    private static long v(long n) {
        while(!isPrime(n)) n--;
        return n;
    }
    
    private static long u(long n) {        
        while(!isPrime(++n));
        return n;
    }
    
    private static long gcd(long x, long y) {
        while (x > 0 && y > 0) {
            if (x < y) y %= x;
            else x %= y;
        }
        return x + y;
    }

}
