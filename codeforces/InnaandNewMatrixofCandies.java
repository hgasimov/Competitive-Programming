package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #234 (Div. 2), Problem B
 */
public class InnaandNewMatrixofCandies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        out.println(solve(in));
        out.flush();
    }
    
    private static int solve(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        
        boolean[] dist = new boolean[m];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            int jG = s.indexOf('G');
            int jS = s.indexOf('S', jG);
            if (jG < jS) dist[jS-jG] = true;
            else return -1;
        }
        
        int sum = 0;
        for (boolean b : dist)
            if (b) sum++;
        return sum;
    }
}
