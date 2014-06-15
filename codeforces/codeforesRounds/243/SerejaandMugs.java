package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #243 (Div. 2), Problem A
 */
public class SerejaandMugs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            s = in.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        
        Arrays.sort(a);
        
        out.println(solve(a, s) ? "YES" : "NO");
        out.flush();
    }
    
    private static boolean solve(int[] a, int s) {
        int sum = 0;
        for (int i = 0; i < a.length-1; i++) {
            sum += a[i];
            if (sum > s) return false;
        }
        
        return true;
    }
    
}
