package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #244 (Div. 2), Problem B
 */
public class PrisonTransfer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(),
            t = in.nextInt(),
            c = in.nextInt();
        
        int[] a = readArray(in, n);
        int tot = 0;
        int i = 0, j = 0;
        while (i < n) {
            while (i < n && a[i] > t) i++;
            if (i == n) break;
            for (j = i+1; j < n && a[j] <= t; j++);
            
            tot += Math.max(0, j - i - c + 1);
            i = j + 1; 
        }
        
        out.println(tot);
        out.flush();
    }

    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
}
