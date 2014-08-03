package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #248 (Div. 2), Problem B
 */
public class KuriyamaMiraisStones {    
    private static int max = 100010;
    private static long[] dv = new long[max];
    private static long[] du = new long[max];
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) du[i] = in.nextLong();
        
        dv = getSum(du, dv, n);
        Arrays.sort(du, 1, n + 1);
        du = getSum(du, du, n);
        
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int type = in.nextInt();
            int l = in.nextInt(),
                r = in.nextInt();
            out.println(type == 1 ? dv[r] - dv[l-1] : du[r] - du[l-1]);
        }
        
        out.flush();
    }
    
    private static long[] getSum(long[] v, long[] dv, int n) {
        for (int i = 1; i <= n; i++)
            dv[i] = dv[i-1] + v[i];
        return dv;
    }
}
