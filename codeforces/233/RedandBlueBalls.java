package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;


/*
 * Codeforces Round #233 (Div. 2), Problem B
 */
public class RedandBlueBalls {
    private static int k = 0;
    private static long Rk = 0;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        String s = in.next();
        
        //System.out.println(R(2));
        long sum = 0;
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == 'B') {
                sum += 1 + R(i);
                //System.out.println(i + " " + sum);
            }
        
        out.print(sum);
        out.flush();
    }
    
    private static long R(int m) {
        if (k == m) return Rk;
        
        for (; k < m; k++) {
            Rk = 2 * Rk + 1; 
        }
        return Rk;
    }
}
