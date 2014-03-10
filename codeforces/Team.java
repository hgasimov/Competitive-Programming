package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #235 (Div. 2), Problem C
 */
public class Team {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        int min_1 = m % 2 == 0 ? m/2 : m/2+1;
        if (n + 1 >= min_1 && n - 1 <= m) {
            boolean zero_turn = n > m;
            
            while (n > 0 || m > 0) {
                if (zero_turn) {
                    out.print("0");
                    n--;
                }
                else {
                    if (m > 1 && m - n > 1) {
                        out.print("11");
                        m -= 2;
                    }
                    else {
                        out.print("1");
                        m--;
                    }
                }
                
                zero_turn = !zero_turn;
            }
        }
        else {
            out.println("-1");
        }
        
        out.flush();
    }
}
