package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #230 (Div. 2), Problem D
 */
public class TowerofHanoi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
       
        long[][] t = new long[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                t[i][j] = in.nextLong();
        
        int n = in.nextInt();
        
        long[][] dp = new long[3][3];        
        long[][] dp_prev = new long[3][3];        
                
        for (int k = 0; k < n; k++) {
            copy(dp, dp_prev);
            
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    
                    int other = other(i, j);
                    long cost1 = dp_prev[i][other] + t[i][j] + dp_prev[other][j];
                    long cost2 = dp_prev[i][j] + t[i][other] + dp_prev[j][i] + t[other][j] + dp_prev[i][j];
                    dp[i][j] = Math.min(cost1, cost2);
                }
        }
        
        out.println(dp[0][2]);
        out.flush();
    }
    
    private static void copy(long[][] from, long[][] to) {
        for (int i = 0; i < 3; i++)
            System.arraycopy(from[i], 0, to[i], 0, 3);
    }
    
    private static int other(int i, int j) {
        if (0 != i && 0 != j) return 0;
        if (1 != i && 1 != j) return 1;
        return 2;
    }    
}
