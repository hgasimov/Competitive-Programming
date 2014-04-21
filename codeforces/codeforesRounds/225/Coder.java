package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #225 (Div. 2)
 */
public class Coder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();        
        
        if (N % 2 == 0)
            out.println(N*N/2);
        else 
            out.println((N/2)*(N/2) + (N/2 + 1)*(N/2 + 1));
        
        int prev_j = 0;
        int cnt = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j >= prev_j && (j-prev_j) % 2 == 0) 
                    out.print('C');
                else
                    out.print('.');
            }
            
            prev_j = (prev_j + 1) % 2;
            out.println("");
        }
        
        
        out.flush();
    }
}
