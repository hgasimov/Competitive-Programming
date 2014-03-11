package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #235 (Div. 2), Problem D
 * exceeds time limit in the test 10
 */
public class RomanandNumbers {
    private static long count = 0;
    private static boolean[] marked;
    private static byte[] perm;
    private static byte[] bn;
    private static long m;
    private static int N;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        bn = toByteArray(in.next().toCharArray());
        m = in.nextLong();
        
        N = bn.length;
        marked = new boolean[N];
        perm = new byte[N];
        
        recur(0);
        
        int[] ccnt = new int[10]; // char count in bn
        for (int i = 0; i < N; i++) ccnt[bn[i]]++;
        int[] fact = new int[20];
        fact[0] = 1;
        for (int i = 1; i < 20; i++) fact[i] = fact[i-1] * i;
        for (int i = 0; i < 10; i++) count /= fact[ccnt[i]];
        
        out.println(count);
        out.flush();
    }
    
    private static void recur(int level) {
        if (level >= N) {
            long lperm = toLong(perm);
            
            if (lperm % m == 0) count++;                
            return;
        }
        
        for (int i = 0; i < N; i++)
            if (!marked[i]) {
                if (level == 0 && bn[i] == 0) continue;
                marked[i] = true;
                
                perm[level] = bn[i];
                recur(level + 1);
                
                marked[i] = false;
            }
    }
    
    private static byte[] toByteArray(char[] a) {
        byte[] ba = new byte[a.length];
        for (int i = 0; i < a.length; i++)
            ba[i] = (byte)(a[i] - '0');
        return ba;
    }
    
    private static long toLong(byte[] a) {
        long sum = 0;
        long mult = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            sum += a[i] * mult;
            mult *= 10;
        }
        return sum;
    }
}
