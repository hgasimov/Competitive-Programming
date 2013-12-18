/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author huseyngasimov
 */
public class InnaAndNine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s = in.next();
        int N = s.length();
        if (N < 3) {
            out.println(1);            
        }
        else {
            long[] prev2 = new long[2];
            long[] prev = new long[2];       
            prev2[0] = prev[0] = 1;
            if (sum(N-1, N-2, s) == 9) prev[1] = 1;
            
            long[] cur = new long[2];
            for (int i = N-3; i >= 0; i--) {
                if (sum(i, i+1, s) == 9) {
                    if (prev2[1] + 1 == prev[1]) {
                        cur[0] = prev[0] + prev2[0];
                        cur[1] = prev[1];
                    }
                    else {
                        cur[0] = prev2[0];
                        cur[1] = prev2[1] + 1;
                    }
                }
                else {
                    System.arraycopy(prev, 0, cur, 0, 2);                  
                }
                
                System.arraycopy(prev, 0, prev2, 0, 2);
                System.arraycopy(cur, 0, prev, 0, 2);
            }
            
            out.println(cur[0]);
        }
        
        out.flush();
    }
    
    private static int sum(int i, int j, String s) {
        return (int) s.charAt(i) + (int) s.charAt(j) - 2* (int)'0';
    }
}
