package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #231 (Div. 2), Problem A
 */
public class CountingSticks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        String s = in.next();
        int A = s.indexOf('+');  // System.out.println("A = " + A);    
        int B = s.indexOf('=', A) - A - 1;  // System.out.println("B = " + B); 
        int C = s.length() - A - B - 2; // System.out.println("C = " + C); 
        
        int dif = Math.abs(A + B - C);
        if (dif == 1 || dif > 2) {
            out.println("Impossible");
        }
        else if (A + B == C) {
            out.println(s);
        }
        else if (A + B + 1 == C - 1) {
            out.println("|" + s.substring(0, s.length() - 1));
        }
        else {
            if (A > 1) out.println(s.substring(1) + "|");
            else out.println(s.substring(0, A+1) + s.substring(A+2) + "|");
        }
        
        out.flush();
    }
}
