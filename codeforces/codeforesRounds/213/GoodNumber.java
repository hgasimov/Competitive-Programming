/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #213 (DIV 2)                                                                                                         
 *
 * @author huseyngasimov
 */
public class GoodNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int k = in.nextInt();
        
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (isKGood(in.next(), k)) c++;
        }
        
        out.print(c);
        out.flush();
    }    
    
    private static boolean isKGood(String s, int k) {
        boolean[] exists = new boolean[k+1];
        for (char c : s.toCharArray()) {
            if (c-'0' <= k)
                exists[c-'0'] = true;
        }
        
        for (boolean b: exists)
            if (!b) return false;
        
        return true;
    }
}
