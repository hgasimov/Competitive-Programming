package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #238 (Div. 2), Problem A
 */
public class GravityFlip {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        
        Arrays.sort(a);
        
        for (int i = 0; i < n; i++)
            out.print(a[i] + " ");
        out.flush();
    }
}
