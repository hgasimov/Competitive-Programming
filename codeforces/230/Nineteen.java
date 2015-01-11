package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #230 (Div. 2), Problem A
 */
public class Nineteen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        String s = in.next();
        int n = 0, e = 0, i = 0, t = 0;
        for (int j = 0; j < s.length(); j++)
            switch(s.charAt(j)) {
                case 'n': n++; break;
                case 'e': e++; break;
                case 'i': i++; break;
                case 't': t++; break;                    
            }
        
        n = n < 3 ? 0: (n - 3)/2 + 1;
        e /= 3;
        
        int min = Math.min(n, e);
        min = Math.min(min, i);
        min = Math.min(min, t);
        out.println(min);
        out.flush();
    }
}
