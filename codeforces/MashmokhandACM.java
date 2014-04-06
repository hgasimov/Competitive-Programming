package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #240 (Div. 2), Problem D
 */
public class MashmokhandACM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int m = 1000000007;
        int n = in.nextInt(),
            k = in.nextInt();
            
        if (k == 1) {
            out.println(n);
        }
        else {
            long[] dp_prev = new long[n+1];
            Arrays.fill(dp_prev, 1);
            dp_prev[0] = 0;
        
            long[] dp = new long[n+1];
            for (int i = 1; i < k; i++) {
                for (int j = 1; j <= n; j++) {
                    long sum = 0;
                    for (int num = j; num <= n; num += j)
                        sum = (sum + dp_prev[num]) % m;                    
                    
                    dp[j] = sum;
                }
                
                System.arraycopy(dp, 1, dp_prev, 1, n);
            }
            
            long sum = 0;
            for (long i : dp) sum = (sum + i) % m;
            out.println(sum);
        }
        
        out.flush();
    }
}
