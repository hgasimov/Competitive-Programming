package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #228 (Div 2)
 */
public class FoxandNumberGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();        
        int[] x = new int[N];
        
        for (int i = 0; i < N; i++) {
            x[i] = in.nextInt();
        }
        
        boolean changed = true;
        while (changed) {
            changed = false;
            Arrays.sort(x);
            
            for (int i = 1; i < N; i++) 
                if (x[i] > x[i-1]) {
                    x[i] -= x[i-1];
                    changed = true;
                }
        }
        
        int sum = 0;
        for (int i : x) sum += i;
        
        out.println(sum);
        out.flush();
    }
}
