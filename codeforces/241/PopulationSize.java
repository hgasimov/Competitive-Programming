package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #241 (Div. 2), Problem D
 */
public class PopulationSize {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        
        int sum = 0;
        int prog_start = 0;
        int dif = -1;
        boolean dif_set = false;
        int prev = -1, prev_i = -1;
        
        
        for (int i = 0; i < n; i++) {
            if (a[i] == -1) {
                if (dif_set && dif < 0 && a[prog_start] + dif * (i - prog_start) <= 0) {
                    sum++;
                    dif_set = false;
                    prog_start = i;
                    prev = -1;
                }
                
                continue;
            }            
            
            if (prev > -1) {
                if (dif_set) {
                    if (Math.abs(a[i] - prev) % (i - prev_i) != 0 || (a[i] - prev) / (i - prev_i) != dif) {
                        sum++;
                        dif_set = false;
                        prog_start = i;
                    }
                }
                else {
                    if (Math.abs(a[i] - prev) % (i - prev_i) == 0) {
                        dif = (a[i] - prev) / (i - prev_i);
                        if (ok(a, prog_start, i, dif)) {
                            prog_start = i;
                            dif_set = true;
                        }
                        else {
                            sum++;
                            dif_set = false;
                            prog_start = i;
                        }
                    }
                    else {
                        sum++;
                        dif_set = false;
                        prog_start = i;
                    }
                }
            }
            
            prev = a[i];
            prev_i = i;
        }
        
        out.println(sum + 1);
        out.flush();
    }
    
    private static boolean ok(int[] a, int prog_start, int i, int dif) {
        for (int j = i; j >= prog_start; j--)
            if (a[j] == -1 && dif > 0 && a[i] - dif * (i - j) <= 0)
                return false;
        return true;    
    }
}
