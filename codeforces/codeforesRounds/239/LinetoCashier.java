package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #239 (Div. 2), Problem A
 */
public class LinetoCashier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int[] k = new int[n];
        for (int i = 0; i < n; i++) k[i] = in.nextInt();
        
        long minTime = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long time = 0;
            for (int j = 0; j < k[i]; j++)
                time += in.nextInt() * 5 + 15;
            
            minTime = Math.min(minTime, time);
        }
        
        out.println(minTime);
        out.flush();
    }
}
