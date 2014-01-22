package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #225 (Div. 2)
 */
public class Multitasking {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();        
        int m = in.nextInt();        
        int k = in.nextInt();
        
        int[][] arrays = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) 
                arrays[i][j] = in.nextInt();
        
        out.println(m*(m-1)/2);
        
        for (int i = 1; i <= m-1; i++)
            for (int j = i+1; j <= m; j++) {
                if (k == 0)
                    out.println(i + " " + j);
                else
                    out.println(j + " " + i);
            }
        
        out.flush();
    }
}
