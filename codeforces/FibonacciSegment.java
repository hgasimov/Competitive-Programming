/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author huseyngasimov
 */
public class FibonacciSegment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        if (n < 3) {
            out.println(n);            
        }
        else {
            int a2 = in.nextInt();
            int a1 = in.nextInt();
            int start = 0;
            int maxlen = 2;
            
            int i;
            for (i = 0; i < n-2; i++) {
                int a = in.nextInt();
                if ( a != a2 + a1) {
                    maxlen = Math.max(i + 2 - start, maxlen);                    
                    start = i + 1;
                }
                
                a2 = a1; a1 = a;                
            }
            
            out.println(Math.max(i + 2 - start, maxlen));
        }
        
        out.flush();
    }
}
