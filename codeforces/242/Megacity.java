package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 *  Codeforces Round #242 (Div. 2), Problem B
 */
public class Megacity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            s = in.nextInt();
        
        int[][] locs = new int[n][3];
        for (int i = 0; i < n; i++) {
            locs[i][0] = in.nextInt();
            locs[i][1] = in.nextInt();
            locs[i][2] = in.nextInt();
        }
        
        Arrays.sort(locs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return dist(a1[0], a1[1]) - dist(a2[0], a2[1]);
            }
        });
        
        int i = -1;
        while (s < 1000000 && i < n-1) {
            s += locs[++i][2];
        }
            
        if (s < 1000000) {
            out.println(-1);
        }
        else {
            out.println(i > -1 ? Math.sqrt((double)dist(locs[i][0], locs[i][1])) : 0);        
        }
        out.flush();
    }
    
    private static int dist(int x, int y) {
        return x*x + y*y;
    }
}
