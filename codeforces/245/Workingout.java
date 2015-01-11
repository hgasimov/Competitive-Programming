package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #245 (Div. 2), Problem D
 */
public class Workingout {
    private static int[][] a;
    private static int n, m;	
    private static int[][] maxIahubFrom, maxIahubTo,
                           maxIahubinaFrom, maxIahubinaTo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        n = in.nextInt();
		m = in.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = in.nextInt();
        
        maxIahubFrom = maxIahubFrom();
        maxIahubTo = maxIahubTo();
        maxIahubinaFrom = maxIahubinaFrom();
        maxIahubinaTo = maxIahubinaTo();      
        
        int max = Integer.MIN_VALUE;
        for (int mi = 1; mi < n-1; mi++)
            for (int mj = 1; mj < m-1; mj++) 
                max = Math.max(max, solve(mi, mj));
            
    	out.println(max);
        out.flush();	
    }
	
    private static int solve(int mi, int mj) {
        return Math.max(
                maxIahubFrom[mi-1][mj] + maxIahubTo[mi+1][mj] + maxIahubinaFrom[mi][mj-1] + maxIahubinaTo[mi][mj+1], 
                maxIahubFrom[mi][mj-1] + maxIahubTo[mi][mj+1] + maxIahubinaFrom[mi+1][mj] + maxIahubinaTo[mi-1][mj]
               );
    }

    private static int[][] maxIahubFrom() {
        int[][] dp = new int[n][m];
        dp[0][0] = a[0][0];
        for (int j = 1; j < m; j++)
            dp[0][j] = a[0][j] + dp[0][j-1];
        for (int i = 1; i < n; i++)
            dp[i][0] = a[i][0] + dp[i-1][0];

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                dp[i][j] = a[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);

        return dp;
    }

    private static int[][] maxIahubTo() {
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = a[n-1][m-1];
        for (int i = n-2; i >= 0; i--)
            dp[i][m-1] = a[i][m-1] + dp[i+1][m-1]; 
        for(int j = m-2; j >= 0; j--)
            dp[n-1][j] = a[n-1][j] + dp[n-1][j+1];

        for (int i = n-2; i >= 0; i--)
            for (int j = m-2; j >= 0; j--)
                dp[i][j] = a[i][j] + Math.max(dp[i+1][j], dp[i][j+1]);

        return dp;
    }

    private static int[][] maxIahubinaFrom() {
        int[][] dp = new int[n][m];

        dp[n-1][0] = a[n-1][0];
        for (int i = n-2; i >= 0; i--)
            dp[i][0] = a[i][0] + dp[i+1][0];
        for (int j = 1; j < m; j++)
            dp[n-1][j] = a[n-1][j] + dp[n-1][j-1];

        for (int i = n-2; i >= 0; i--)
            for (int j = 1; j < m; j++)
                dp[i][j] = a[i][j] + Math.max(dp[i+1][j], dp[i][j-1]);

        return dp;
    }

    private static int[][] maxIahubinaTo() {
        int[][] dp = new int[n][m];

        dp[0][m-1] = a[0][m-1];
        for (int i = 1; i < n; i++)
            dp[i][m-1] = a[i][m-1] + dp[i-1][m-1];
        for (int j = m-2; j >= 0; j--)
            dp[0][j] = a[0][j] + dp[0][j+1];

        for (int i = 1; i < n; i++)
            for (int j = m-2; j >= 0; j--)
                dp[i][j] = a[i][j] + Math.max(dp[i-1][j], dp[i][j+1]);

        return dp;
    }
}