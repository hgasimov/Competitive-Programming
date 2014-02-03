package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #228 (Div 2)
 */
public class FoxandCross {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();        
        char[][] x = new char[N][N];
        
        for (int i = 0; i < N; i++) {            
            x[i] = in.next().toCharArray();
        }
        
        //printArray(x[1]);
        
        out.println(solve(x, N));
        out.flush();
    }
    
    private static String solve(char[][] x, int N) {
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) 
                if (x[i][j] == '#') {  
                    if (!remove(x, N, i, j)) return "NO";
                    if (!remove(x, N, i+1, j-1)) return "NO";
                    if (!remove(x, N, i+1, j)) return "NO";
                    if (!remove(x, N, i+1, j+1)) return "NO";
                    if (!remove(x, N, i+2, j)) return "NO";
                }
        
        return "YES";
    }
    
    private static boolean remove(char[][] x, int N, int i, int j) {
        if (i < 0 || i > N-1) return false;
        if (j < 0 || j > N-1) return false;
        if (x[i][j] != '#') return false;
        
        x[i][j] = '.';
        return true;
    }
}
