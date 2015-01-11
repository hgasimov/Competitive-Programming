package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #239 (Div. 2), Problem D
 */
public class LongPath {
    private static final long m = 1000000007;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int[] portal_1 = new int[n];        
        for (int i = 0; i < n; i++)
            portal_1[i] = in.nextInt() - 1;
        
        long[] dp = new long[n];
        dp[0] = 2;        
        for (int i = 1; i < n; i++) {
            long add = portal_1[i] == 0 ? dp[i-1] : (dp[i-1] - dp[portal_1[i]-1] + m) % m;
            dp[i] = (dp[i-1] + 2 + add) % m;
        }
        
        out.println(dp[n-1]);
        out.flush();
    }
}
