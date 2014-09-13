package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #266 (Div. 2), Problem A
 */
public class CheapTravel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(), 
            m = in.nextInt(), 
            a = in.nextInt(), 
            b = in.nextInt(); 

        if (((double)b) / m >= a) {
            out.println(n * a);
        }
        else {
            int sum = 0;
            if (n > m) {
                int tmp = n / m;
                n -= tmp * m;
                sum +=  tmp * b;
            }
            
            sum += Math.min(n * a, b);
            out.println(sum);
        }
        out.flush();
    }
}
