package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #239 (Div. 2), Problem C
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int a = in.nextInt(),
            b = in.nextInt();
        boolean solved = false;
        
        for (int i = 1; i < a; i++) 
            if (isInt(Math.sqrt(a*a - i*i))) {
                double tmp = ((double)b * i) / a;                
                if (isInt(tmp)) {
                    int j = (int) -tmp;
                    
                    if (isInt(Math.sqrt(b*b - j*j))) {
                        int other = (int)Math.sqrt(b*b - j*j);
                        if (i == other) continue;
                    
                        out.println("YES");
                        out.println("0 0");
                        out.println((int)Math.sqrt(a*a - i*i) + " " + i);
                        out.println(j + " " + other);
                        solved = true;
                        break;
                    }
                }
            }
        
        if (!solved) {
            out.println("NO");
        }
        
        out.flush();
    }
    
    private static boolean isInt(double d) {
       return Double.compare(d, (int)d) == 0;
    }
}
