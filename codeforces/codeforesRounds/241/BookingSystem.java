package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Codeforces Round #241 (Div. 2), Problem C
 */
public class BookingSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int[][] req = new int[n][3];
        for (int i = 0; i < n; i++) {
            req[i][0] = i+1;
            req[i][1] = in.nextInt();
            req[i][2] = in.nextInt();
        }
            
        int k = in.nextInt();
        int[][] t = new int[k][2];
        for (int i = 0; i < k; i++) {
            t[i][0] = i+1;
            t[i][1] = in.nextInt();
        }
        
        Arrays.sort(req, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        
        Arrays.sort(t, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        int[] marked = new int[k];
        int m = 0, sum = 0;
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < k; j++)
                if (req[i][1] <= t[j][1] && marked[j] == 0) {
                    marked[j] = req[i][0];
                    sum += req[i][2];
                    m++;
                    break;
                }
        }
        
        out.println(m + " " + sum);
        for (int i = 0; i < k; i++)
            if (marked[i] > 0)
                out.println(marked[i] + " " + t[i][0]);
        
        out.flush();
    }
}
