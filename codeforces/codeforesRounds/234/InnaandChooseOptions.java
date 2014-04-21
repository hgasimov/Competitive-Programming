package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #234 (Div. 2), Problem A
 */
public class InnaandChooseOptions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int  t = in.nextInt();
        for (int i = 0; i < t; i++)
            solveAndPrint(out, in.next());
        
        out.flush();
    }
    
    private static void solveAndPrint(PrintWriter out, String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int a = 1; a <= 12; a++)
            if (12 % a == 0) {
                int b = 12/a;
                if (isWin(s, a, b)) {
                    cnt++;
                    sb.append(a + "x" + b + " ");
                }
            }
        
        out.println(cnt + " " + sb.toString().trim());        
    }
    
    private static boolean isWin(String s, int a, int b) {
        for (int i = 0; i < b; i++)
            for (int j = i; j < s.length(); j += b)
                if (s.charAt(j) == 'O') break;
                else if (j + b >= s.length()) return true;
        return false;
    }
}
