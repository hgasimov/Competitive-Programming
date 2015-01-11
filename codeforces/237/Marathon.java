package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #237 (Div. 2), Problem B
 */
public class Marathon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        double a = in.nextDouble();
        double d = in.nextDouble();
        int n = in.nextInt();
        
        double x = 0;
        double l = 4*a;
        for (int i = 0; i < n; i++) {
            x = (x + d) % l;
            int side = (int)(x / a);
            double other = x - side * a;
            switch (side) {
                case 0:
                    out.println(round(other) + " 0");
                    break;
                case 1:
                    out.println(round(a) + " " + round(other));
                    break;
                case 2:
                    out.println(round(a - other) + " " + round(a));
                    break;
                case 3:
                    out.println("0 " + round(a - other));
            }
        }
        
        out.flush();
    }
    
    private static double round(double d) {
        return Math.rint(d * 1E5)/1E5;
    }
}
