package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #229 (Div. 2), Problem A
 */
public class InnaandAlarmClock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        boolean[] x = new boolean[101];
        boolean[] y = new boolean[101];        
        
        int n = in.nextInt();        
        for (int i = 0; i < n; i++) {
            x[in.nextInt()] = true;
            y[in.nextInt()] = true;            
        }

        out.print(Math.min(count(x), count(y)));
        out.flush();
    }
    
    private static int count(boolean[] x) {
        int i = 0;
        for (boolean b : x)
            if (b) i++;
        return i;
    }
}
