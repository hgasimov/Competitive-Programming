package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 *  Codeforces Round #236 (Div. 2), Problem B
 */
public class TreesinaRow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            k = in.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        
        int[] id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
        
        int mini = 0;
        int min = n;
        for (int i = 0; i < n; i++)
            if (i == id[i] && a[i] - i*k > 0) {
                int moves = i;     
                int prev = a[i];
                for (int j = i+1; j < n; j++) {
                    if (a[j] == prev + k) {
                        id[j] = i;
                    }
                    else {
                        moves++;
                    }
                    prev += k;
                }
                
                if (moves < min) {
                    min = moves;
                    mini = i;
                }
            }
        
        out.println(min);
        
        if (mini > 0) {
            int newHight = a[mini] - mini*k;
            out.print(a[0] < newHight ? "+ " : "- ");
            out.print("1 ");
            out.println(Math.abs(a[0] - newHight));
            a[0] = newHight;
        }
        
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i-1] + k) {
                out.print(a[i] < a[i-1] + k ? "+ " : "- ");
                out.print((i+1) + " ");
                out.println(Math.abs(a[i-1] + k - a[i]));
                a[i] = a[i-1] + k;
            }
        }
                
        out.flush();
    }
}
