package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #246 (Div. 2), Problem A
 */
public class ChoosingTeams {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            k = in.nextInt();
        
        int[] y = new int[n];
        for (int i = 0; i < n; i++)
            y[i] = in.nextInt();
        
        Arrays.sort(y);
        
        int i = 0;
        while (i < n && k +  y[i] <= 5) i++;
        
        out.println(i / 3);
        out.flush();
    }
}
