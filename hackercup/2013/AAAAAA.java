package FacebookHackerCup;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Facebook Hacker Cup Round 1 (25 point)
 * @author huseyngasimov
 */
public class AAAAAA {
    public static void main(String[] args) throws FileNotFoundException {        
        String curdir = "io/fb/round1/AAAAAA/";

        Scanner in = new Scanner(new File(curdir + "aaaaaa.txt"));
        PrintWriter out = new PrintWriter(curdir + "out.txt");
        int T = in.nextInt();
            
        for (int caseno = 1; caseno <= T; caseno++) {      
            int N = in.nextInt();
            int M = in.nextInt();
            char[][] grid = new char[N][M];
            
            for (int i = 0; i < N; i++) {
                String line = in.next();
                System.arraycopy(line.toCharArray(), 0, grid[i], 0, M);
            }

            int[][] from = calcFrom(grid, N, M); // max queue length from the entrance 
            int[][] to = calcTo(grid, N, M); // max queue length to the end 
            
            int max = max(from);
            max = run_upward(grid, from, to, N, M, max);
            max = run_left(grid, from, to, N, M, max);
            
            System.out.println("Case #" + caseno + ": " + max);
            out.println("Case #" + caseno + ": " + max);
        }
        
        out.flush();    
    }
    
    private static int[][] calcFrom(char[][] grid, int N, int M) {
        int[][] from = new int[N][M];
        from[0][0] = 1;
        
        for (int i = 1; i < M; i++) {
            if (grid[0][i] == '#' || from[0][i-1] == -1) 
                from[0][i] = -1;
            else
                from[0][i] = from[0][i-1] + 1;
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (grid[i][j] == '#') 
                    from[i][j] = -1;
                else {
                    from[i][j] = -1;
                    if (from[i-1][j] >= 0) from[i][j] = from[i-1][j] + 1;
                    if (j > 0 && from[i][j-1] >= 0) from[i][j] = Math.max(from[i][j], from[i][j-1] + 1);
                }            
        }
        
        return from;
    }
    
    private static int[][] calcTo(char[][] grid, int N, int M) {
        int[][] to = new int[N][M];

        for (int i = N-1; i >= 0; i--) {
            for (int j = M-1; j >= 0; j--)
                if (grid[i][j] == '#') 
                    to[i][j] = -1;
                else {
                    to[i][j] = 1;
                    if (i < N-1 && to[i+1][j] >= 0) to[i][j] = Math.max(to[i][j], to[i+1][j] + 1);
                    if (j < M-1 && to[i][j+1] >= 0) to[i][j] = Math.max(to[i][j], to[i][j+1] + 1);
                }            
        }
        
        return to;
    }

    private static int max(int[][] a) {
        int max = -1;
        for (int[] a1 : a) 
            for (int a2 : a1) max = Math.max(max, a2);
        return max;
    }
    
    private static int run_upward(char[][] grid, int[][] from, int[][] to, int N, int M, int max) {
        for (int j = 1; j < M; j++) {
            for (int ihigh = N-1; ihigh > 0; ihigh--) {
                if (grid[ihigh][j] == '#' || from[ihigh][j-1] < 0) continue;                    
                int left = from[ihigh][j-1];

                for (int ilow = ihigh-1; ilow >=0; ilow--) {
                    if (grid[ilow][j] == '#') break;

                    int straight = ihigh - ilow + 1;
                    int right = j >= M-1 || to[ilow][j+1] < 0 ? 0 : to[ilow][j+1];

                    max = Math.max(max, left + straight + right);
                }
            }
        }
        
        return max;
    }
    
    private static int run_left(char[][] grid, int[][] from, int[][] to, int N, int M, int max) {
        for (int i = 1; i < N; i++) {
            for (int jhigh = M-1; jhigh > 0; jhigh--) {
                if (grid[i][jhigh] == '#' || from[i-1][jhigh] < 0) continue;
                int up = from[i-1][jhigh];
                
                for (int jlow = jhigh-1; jlow >= 0; jlow--) {
                    if (grid[i][jlow] == '#') break;
                    
                    int straight = jhigh - jlow + 1;
                    int down = i >= N-1 || to[i+1][jlow] < 0 ? 0 : to[i+1][jlow];
                    
                    max = Math.max(max, up + straight + down);
                }
            }
        }
        
        return max;
    }
}
