package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #266 (Div. 2), Problem C
 */
public class NumberofWays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = readArray(in, n);        
        long s = 0;
        for (int i : a) s += i;
        
        if (n < 3 || s % 3 != 0) {
            out.println(0);
        }
        else {            
            long targetSum = s / 3;
            int[] cnt = new int[n];
            long tmp = 0;
            for (int i = n - 1; i >= 0; i--) {
                tmp += a[i];
                if (tmp == targetSum) cnt[i] = 1;
            }
            
            int[] sum = new int[n];
            sum[n-1] = cnt[n-1];
            for (int i = n - 2; i >= 0; i--) {
                sum[i] = cnt[i] + sum[i+1];
            }
            
            long total = 0;
            tmp = 0;
            for (int i = 0; i < n-2; i++) {
                tmp += a[i];
                if (tmp == targetSum) 
                    total += sum[i+2];
            }
            out.println(total);
        }

        out.flush();
    }

    
    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
}
