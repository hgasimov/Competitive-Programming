package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #222 (Div. 2) 
 * @author huseyngasimov
 */
public class Semifinals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] first_semi = new int[n];
        int[] second_semi = new int[n];        
        
        for (int i = 0; i < n; i++) {
            first_semi[i] = in.nextInt();
            second_semi[i] = in.nextInt();
        }
        
        int i = 0, j = 0;
        for (int total = 0; total < n; total++) {
            if (first_semi[i] < second_semi[j]) i++;
            else j++;                
        }
        
        int k = n/2;
        i = Math.max(i, k);
        j = Math.max(j, k);
        
        printArray(i, n, out);
        printArray(j, n, out);
        
        out.flush();
    }   
    
    private static void printArray(int k, int n, PrintWriter out) { 
        int i = 0;
        for (; i < k; i++) out.print(1); 
        for (; i < n; i++) out.print(0); 
        out.println();
    }
}
