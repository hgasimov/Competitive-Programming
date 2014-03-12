package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #229 (Div. 2), Problem C
 */
public class InnaandCandyBoxes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int k = in.nextInt();
        int w = in.nextInt();        
        String s = in.next();
        
        int[][] cnt = new int[k][n+1];        
        for (int start = 1; start <= k; start++)
            for (int i = start; i <= n; i++) {
                if ((i - start + 1) % k == 0) {
                    cnt[start-1][i] = (s.charAt(i-1) != '1') ? cnt[start-1][i-1] + 1 : cnt[start-1][i-1];
                }
                else {
                    cnt[start-1][i] = (s.charAt(i-1) != '0') ? cnt[start-1][i-1] + 1 : cnt[start-1][i-1];
                }
            }
        
        for (int i = 0; i < w; i++) {
            int li = in.nextInt();
            int ri = in.nextInt();
            int cntID = (li-1) % k;
            out.println(cnt[cntID][ri] - cnt[cntID][li-1]);
        }
        
        out.flush();
    }
}
