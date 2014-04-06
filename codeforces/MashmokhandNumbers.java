package codeforces;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/*
 * Codeforces Round #240 (Div. 2), Problem C
 */
public class MashmokhandNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            k = in.nextInt();
        
        if (k == 0) {
            out.println(n == 1 ? 1 : -1);
        }
        else if (n < 2 || n / 2 > k) {
            out.println(-1);
        }
        else {
            int nadds = n / 2 - 1;
            int core = k - nadds;
            if (core == 1) {
                for (int i = 1; i <= n; i++)
                    out.print(i + " ");
            }
            else {
                HashSet<Integer> hs = new HashSet<>();
                int other = 2*core;
                hs.add(other);
                out.print(core + " " + other);
                for (int i = 0; i < nadds; i++) {
                    core++;
                    while(hs.contains(core)) core++;
                    other = 2*core + 1;
                    hs.add(other);
                    out.print(" " + core + " " + other);
                }
                
                if (n % 2 > 0) out.print(" 1");
            }
        }
        
        out.flush();
    }
}
