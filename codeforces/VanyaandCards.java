package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #235 (Div. 2), Problem A
 */
public class VanyaandCards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int x = in.nextInt();
        int[] a = readArray(in, n);
        
        int sum = Math.abs(sum(a));
        int cards = sum % x == 0 ? sum / x : sum / x + 1;
                
        out.println(cards);       
        out.flush();
    }
    
    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
    
    private static int sum(int[] a) {
        int sum = 0;
        for (int i : a) sum += i;
        return sum;
    }
}
