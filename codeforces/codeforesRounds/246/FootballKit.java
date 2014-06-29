package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #246 (Div. 2), Problem B
 */
public class FootballKit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        
        int[][] ncol = new int[2][100000 + 1];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            
            ncol[0][x[i]]++;
            ncol[1][y[i]]++;
        }
        
        for (int i = 0; i < n; i++) {
            out.format("%d %d\n", n + ncol[0][y[i]] - 1, n - ncol[0][y[i]] - 1);
        }
            
        
        out.flush();
    }
}
