package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #240 (Div. 2), Problem A
 */
public class MashmokhandLights {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            m = in.nextInt();
        
        int[] a = new int[n+1];
        //Arrays.fill(a, -1);
        
        for (int i = 0; i < m; i++) {
            int bi = in.nextInt();
            for (int j = bi; j <= n; j++)
                if (a[j] < 1) a[j] = bi;
        }
        
        for (int i = 1; i <= n; i++)
            out.print(a[i] + " ");
        out.flush();
    }
}
