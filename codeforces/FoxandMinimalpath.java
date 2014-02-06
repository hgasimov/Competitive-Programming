package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #228 (Div 2)
 */
public class FoxandMinimalpath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int k = in.nextInt();
        
        if (k == 1) {
            out.println(2);
            out.println("NY\nYN");            
        }
        else if (k == 2) {
            out.println(4);
            out.println("NNYY\nNNYY");
            out.println("YYNN\nYYNN");
        }        
        else {
            int n = 32 - Integer.numberOfLeadingZeros(k); //println(n); // number of layers        
            int N = (n + 2)*(n + 1)/2 + 1; //println(N); // number of nodes required
            boolean[][] G = new boolean[N+1][N+1];

            connect(G, 1, 3);
            connect(G, 1, 4);
            
            int start = 3;
            int end = 4;
            for (int i = 2; i <= n; i++) {
                int prev_start = start;
                
                start = end + 1;
                end = start + i;
                createLayer(G, i, start, end, prev_start);
            }
            
            connect2(G, start + 1, k);
            
            printGraph(G, N, out);
        }
        
        out.flush();        
    }
    
    private static void connect2(boolean[][] G, int start, int k) {
        int mask = 1;
        
        for (int i = 0; i < 32; i++, mask = mask << 1) {
            if ((k & mask) > 0)
                connect(G, 2, start + i);
            
        }
    }
    
    private static void printGraph(boolean[][] G, int nodes, PrintWriter out) {
        out.println(nodes);
        
        for (int i = 1; i <= nodes; i++) {
            for (int j = 1; j <= nodes; j++)
                out.print(G[i][j] ? 'Y':'N');
            
            out.println();
        }
    }
    
    private static void createLayer(boolean[][] G, int i, 
            int start, int end, 
            int prev_start) {
        
        connect(G, prev_start, start);
        
        for (int j = 1; start + j <= end; j++) {
            connect(G, start + j, prev_start, prev_start + j - 1);
        }
    }
    
    private static void connect(boolean[][] G, int i, int start, int end) {
        for (int j = start; j <= end; j++)
            connect(G, i, j);
    }
    
    private static void connect(boolean[][] G, int i, int j) {
        G[i][j] = true;
        G[j][i] = true;
    }
    
    private static void printArray(int[] a) { for (int i: a) println(i); }    
    private static void println(Object o) { System.out.println(o);}

    
}
