//package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #259 (Div. 2), Problem C
 */
public class LittlePonyandExpectedMaximum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        out.println(solve(in.nextInt(), in.nextInt()));
        out.flush();
    }
    
    private static double solve(int m, int n) {
        double sum = 0;
        double multp = 1;
        
        while (m > 0) {            
            double pm = calcPM(m, n);
            sum += multp * pm * m;
            
            multp *= 1 - pm;
            m--;
        }
        
        return sum;
    }
    
    private static double calcPM(double m, int n) {
        if (m == 1) return 1;
        return 1 - Math.pow(1 - 1/m, n);
    }
}
