package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #228 (Div 2)
 */
public class FoxandBoxAccumulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();        
        int[] x = new int[N];
        boolean[] used = new boolean[N];
        
        for (int i = 0; i < N; i++) {            
            x[i] = in.nextInt();
        }
        
        Arrays.sort(x);
        
        int nUsed = 0;
        int nPiles = 0;
        while(nUsed < N) {
            nUsed += createPile(N, x, used);
            nPiles++;
        }
        
        out.println(nPiles);
        out.flush();
    }
    
    private static int createPile(int N, int[] x, boolean[] used) {
        int nBoxes = 0;
        
        for (int i = 0; i < N; i++)
            if (!used[i] && x[i] >= nBoxes) {
                used[i] = true;
                nBoxes++;
            }
        
        return nBoxes;
    }
}
