package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #237 (Div. 2), Problem A
 */
public class ValeraandX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        String[] paper = new String[n];
        for (int i = 0; i < n; i++) 
            paper[i] = in.next();
        
        out.println(check(paper, n) ? "YES" : "NO");
        out.flush();
    }
    
    private static boolean check(String[] paper, int n) {
        char dc = paper[0].charAt(0);
        char oc = paper[0].charAt(1);
        if (dc == oc) return false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = paper[i].charAt(j);
                if (j == i || j == n-1-i) {
                    if (c != dc) return false;
                }
                else {
                    if (c != oc) return false;
                }
            }
        }
        
        return true;
    }
}
