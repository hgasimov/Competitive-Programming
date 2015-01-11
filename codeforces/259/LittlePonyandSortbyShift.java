//package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #259 (Div. 2), Problem B
 */
public class LittlePonyandSortbyShift {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = readArray(in, n);
        
        int mini = 0;
        for (int i = 1; i < n; i++)
            if (a[i] <= a[mini]) mini = i;
        
        while (mini > 0 && a[mini - 1] == a[mini]) mini--;
        
        out.println(solve(a, mini));
        out.flush();
    }

    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
    
    private static int solve(int[] a, int mini) {
        int n = a.length;
        int i = mini, j = (mini + 1) % n;
        while (j != mini) {
            if (a[j] < a[i]) return -1;
            i = j;
            j = (j + 1) % n;
        }
        //if (a[j] < a[i]) return -1;    
        
        return mini == 0 ? 0 : n - mini;
    }
}
