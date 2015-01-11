/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Codeforces Round #215 (Div. 2)
 * @author huseyngasimov
 */
public class SerejaAndSuffixes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        int[] l = new int[m];
        int minli = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            l[i] = in.nextInt() - 1;
            minli = Math.min(l[i], minli);
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        int[] distinct = new int[n];
        for(int i = n-1; i >= minli; i--) {
            set.add(a[i]);
            distinct[i] = set.size();
        }
        
        for (int j = 0; j < m; j++) { out.println(distinct[l[j]]); }
        
        out.flush();
    }
}
