//package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Codeforces Round #245 (Div. 2), Problem A
 */
public class PointsandSegments {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            m = in.nextInt();
        int[][] x = new int[n][3];
        for (int i = 0; i < n; i++) {
            x[i][0] = i;
            x[i][1] = in.nextInt();
        }
        
        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });        
        
        for (int i = 0; i < n; i++)
            x[i][2] = i % 2 == 0 ? 1 : 0;
        
        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        for (int i = 0; i < n; i++)
            out.print(x[i][2] + " ");
        
        out.flush();
    }
}
