package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 *  Codeforces Round #242 (Div. 2), Problem D
 */
public class BiathlonTrack {
    private static long tp, tu, td;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            m = in.nextInt();
        
        long t = in.nextLong();
        tp = in.nextLong(); // flat
        tu = in.nextLong(); // ascend
        td = in.nextLong(); // descend
        
        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = in.nextLong();
        
        long[][] right = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 1; j < m; j++)
                right[i][j] = right[i][j-1] + calc(a[i][j-1], a[i][j]);
        
        
        long[][] left = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int j = m-2; j >= 0; j--)
                left[i][j] = left[i][j+1] + calc(a[i][j+1], a[i][j]);                
        
        long[][] up = new long[n][m];
        for (int j = 0; j < m; j++)
            for (int i = 1; i < n; i++)
                up[i][j] = up[i-1][j] + calc(a[i-1][j], a[i][j]);                       
        
        long[][] down = new long[n][m];
        for (int j = 0; j < m; j++)
            for (int i = n-2; i >= 0; i--)
                down[i][j] = down[i+1][j] + calc(a[i+1][j], a[i][j]);
        
        long rt = Long.MAX_VALUE;
        int ri1 = -1, ri2 = -1, rj1 = -1, rj2 = -1;
        for (int i1 = 0; i1 < n-2; i1++)
            for (int j1 = 0; j1 < m-2; j1++)
                for (int i2 = i1+2; i2 < n; i2++)
                    for (int j2 = j1+2; j2 < m; j2++) {
                        long ct = right[i1][j2] - right[i1][j1] + 
                                  up[i2][j2] - up[i1][j2] +
                                  left[i2][j1] - left[i2][j2] +
                                  down[i1][j1] - down[i2][j1];
                        if (Math.abs(t - ct) < Math.abs(t - rt)) {
                            ri1 = i1; ri2 = i2; rj1 = j1; rj2 = j2;
                            rt = ct;
                        }
                    }
               
        out.format("%d %d %d %d\n", ri1+1, rj1+1, ri2+1, rj2+1);
        out.flush();
    }
    
    private static long calc(long h1, long h2) {
        if (h1 == h2) return tp;
        if (h1 < h2) return tu;
        return td;
    }
}
