package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #241 (Div. 2), Problem B
 */
public class ArtUnion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int m = in.nextInt(),
            n = in.nextInt();
        
        int[][] t = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) 
                t[i][j] = in.nextInt();
        
        int[] it = new int[m+1];
        Arrays.fill(it, Integer.MIN_VALUE);
        it[0] = 0;
        
        for (int j = 0; j < n; j++)
            for (int i = 1; i <= m; i++) {
                it[i] = Math.max(it[i], it[i-1]) + t[i-1][j];
            }
        
        for (int i = 1; i <= m; i++)
            out.print(it[i] + " ");
        out.flush();
    }
}
