package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #226 (Div. 2), Problem B
 */
public class BearandStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        String s = in.next();        
        int n = s.length();
        int sum = 0;        
        int start = -1;
        for (int i = 0; i < n - 3; i++) 
            if (s.substring(i, i + 4).equals("bear")) {
                sum += (i - start) * (n - i - 3);
                start = i;
            }
        
        out.println(sum);
        out.flush();
    }
}
