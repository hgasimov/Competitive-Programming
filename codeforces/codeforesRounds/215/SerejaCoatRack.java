/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Codeforces Round #215 (Div. 2)
 * @author huseyngasimov
 */
public class SerejaCoatRack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int d = in.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        int m = in.nextInt();
        if (m < n) {
            Arrays.sort(a);
            int sum = 0;
            for (int i = 0; i < m; i++) sum += a[i];
            out.print(sum);
        }
        else {
            int sum = 0;
            for (int i: a) sum += i;
            out.print(sum - (m-n)*d);
        }   
        
        out.flush();
    }
}
