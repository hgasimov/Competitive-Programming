package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #230 (Div. 2), Problem B
 */
public class Threematrices {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        double[][] W = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                W[i][j] = in.nextInt();
        
        double[][] A = new double[n][n];
        double[][] B = new double[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                B[i][j] = (W[i][j] - W[j][i]) / 2;
                B[j][i] = - B[i][j];
                A[i][j] = A[j][i] = W[i][j] - B[i][j];
            }
        
        printMatrix(A, out);
        printMatrix(B, out);
        
        out.flush();
    }
    
    private static void printMatrix(double[][] A, PrintWriter out) {
        for (int i = 0; i < A.length; i++) {            
            for (int j = 0; j < A.length; j++)
                out.print(A[i][j] + " ");
            out.println();
        }                
    }
}
