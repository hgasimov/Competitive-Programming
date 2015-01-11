package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #230 (Div. 2), Problem C
 */
public class BlockedPoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        double n = in.nextDouble();
        double sum = 0;
        if (n >= 1) {
            int add4 = 0; // for the four 'x=y' points
            double nsqr = Math.pow(n, 2);
            double y1, y2 = 0;
            
            for (double x = n-1; x > 0; x--) {
                double xsqr = Math.pow(x, 2);        
                y1 = Math.sqrt(nsqr - xsqr); 
                
                if (y1 >= x) {
                    if (x > y2) add4 = 4;
                    if (x - Math.floor(y2) > 1)
                        sum += x - Math.floor(y2) - 1;
                    break;
                }

                sum += Math.floor(y1) - Math.floor(y2);
                y2 = y1;
            }
            
            out.println(((int)sum) * 8 + 4 + add4);        
        }
        else {
            out.println(1);
        }
        out.flush();
    }
}
