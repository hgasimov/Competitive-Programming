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
public class FixingTypos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);   
        
        String s1 = in.next();        
        if (s1.length() < 3) {
            out.println(s1);
            out.flush();
            return;
        }                
        
        char[] s = s1.toCharArray();
        out.print(s[0]);
        out.print(s[1]);

        int i0 = 0, i1 = 1, i2 = 2;
        int N = s.length;
        
        if (s[0] == s[1]) {
            while (i2 < N && s[0] == s[i2])
                i2++;
        }
        
        if (i2 < N) out.print(s[i2]);
        
        int i3 = i2 + 1;      
        while (i3 < N) {
            if (((s[i0] == s[i1]) && (s[i2] == s[i3]))
                    || (s[i1] == s[i2] && s[i1] == s[i3])) {
                
                i3++;
            }
            else {
                out.print(s[i3]);
                
                i0 = i1;
                i1 = i2;
                i2 = i3;
                i3++;
            }
        }        
        
        out.flush();
    }
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
