package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Codeforces Round #237 (Div. 2), Problem C
 */
public class RestoreGraph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            k = in.nextInt();
        
        int[][] d = new int[n][2];
        for (int i = 0; i < n; i++) {
            d[i][0] = in.nextInt();
            d[i][1] = i+1;
        }
        
        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int[][] edges = repair(d, n, k);
        if (edges == null) {
            out.println(-1);
        }
        else {
            out.println(n-1);
            for (int i = 0; i < n-1; i++)
                out.println(edges[i][0] + " " + edges[i][1]);
        }
        
        out.flush();
    }
    
    private static int[][] repair(int[][] d, int n, int k) {
        if (d[0][0] != 0) return null;
        
        int[][] edges = new int[n-1][2];            
        int ei = 0;

        int j = 0;
        int[] outdeg = new int[n];
        for (int i = 1; i < n; i++) {
            while (outdeg[j] == k) j++;
            while (d[i][0] - d[j][0] > 1) j++;                
            if (d[i][0] <= d[j][0]) return null;

            edges[ei][0] = d[j][1];
            edges[ei][1] = d[i][1];
            ei++;
            outdeg[j]++;
            outdeg[i]++;            
        }
        
        return edges;
    }
}
