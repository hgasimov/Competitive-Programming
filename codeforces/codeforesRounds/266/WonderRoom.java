package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #266 (Div. 2), Problem B
 */
public class WonderRoom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong(), 
            a = in.nextLong(), 
            b = in.nextLong();
        
        long smin = n * 6;
        long s = a * b;
        
        if (s >= smin) {
            out.println(s);
            out.println(a + " " + b);
        }
        else {
            main:
            for (s = smin;; s++) {
                if (a <= b) {
                    for (long a1 = a; a1*a1 <= s; a1++)
                        if (s % a1 == 0 && s / a1 >= b) {
                            out.println(s);
                            out.println(a1 + " " + (s / a1));
                            break main;
                        }
                }
                else {
                    for (long b1 = b; b1*b1 <= s; b1++)
                        if (s % b1 == 0 && s / b1 >= a) {
                            out.println(s);
                            out.println((s / b1) + " " + b1);
                            break main;
                        }
                }
            }
        }

        out.flush();
    }
}
