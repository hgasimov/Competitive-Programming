package FacebookHackerCup.hc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WinningatSports {
    private static String curdir = "io//fb//round1//WinningatSports//";
    private static Scanner in;
    private static PrintWriter out;
    private static int mod = 1000000007;
    
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File(curdir + "winning_at_sports.txt"));
        out = new PrintWriter(curdir + "round1_problemC_output.txt");
                
        int T = in.nextInt();        
        for (int caseno = 1; caseno <= T; caseno++) {
            String[] score = in.next().split("-");
            int a = Integer.parseInt(score[0]);
            int b = Integer.parseInt(score[1]);
            
            printf("Case %d#: %d %d\n", caseno, dpStressFree(a, b), dpStressfull(b));
        }

        out.flush();
    }

    private static int dpStressFree(int a, int b) {
        int[] dp = new int[a + 1];
        for (int i = 0; i <= a; i++)
            dp[i] = 1;
        
        int[] dp_prev = new int[a + 1];
        for (int j = 1; j <= b; j++) {
            int[] tmp = dp_prev;
            dp_prev = dp;
            dp = tmp;
            
            dp[j+1] = dp_prev[j+1];
            
            for (int i = j + 2; i <= a; i++)
                dp[i] = (dp[i-1] + dp_prev[i]) % mod;            
        }
        
        return dp[a];
    }
    
    private static int dpStressfull(int b) {
        int[] dp = new int[b + 1];
        for (int j = 0; j <= b; j++)
            dp[j] = 1;
        
        int[] dp_prev = new int[b + 1];
        for (int i = 1; i <= b; i++) {
            int[] tmp = dp_prev;
            dp_prev = dp;
            dp = tmp;
            
            dp[i] = dp_prev[i];
            
            for (int j = i+1; j <= b; j++)
                dp[j] = (dp_prev[j] + dp[j-1]) % mod;                        
        }
        
        return dp[b];
    }
    
    private static void printf(String format, Object... args) {
        out.format(format, args);
        System.out.format(format, args);
    }
}
