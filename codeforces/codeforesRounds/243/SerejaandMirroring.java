package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #243 (Div. 2), Problem B
 */
public class SerejaandMirroring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            m = in.nextInt();
        
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = in.nextInt();
        
        while (isSymmetric(a, n, m)) 
            n /= 2;
        
        out.println(n);
        out.flush();
    }
    
    private static boolean isSymmetric(int[][] a, int n, int m) {
        if (n % 2 > 0) return false;
                
        for (int i = 0; i < n/2; i++) {
            if (!Arrays.equals(a[i], a[n - i - 1])) return false;
        }
        
        return true;
    }
}
