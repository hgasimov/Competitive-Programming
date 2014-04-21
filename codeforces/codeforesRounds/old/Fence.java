/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author huseyngasimov
 */
public class Fence {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();
        int K = in.nextInt();                

        if (K == N) {
            out.println(1);
            out.flush();
            return;
        }
        
        int i;
        int[] fences = new int[N];
        for (i = 0; i < N; i++)
            fences[i] = in.nextInt();
        
        int sum = 0;
        for (i = 0; i < K; i++)
            sum += fences[i];
        
        int min = sum;
        int argmin = K-1;
        for (i = K; i < N; i++) {
            sum += fences[i] - fences[i-K];
            if (sum < min) {
                min = sum;
                argmin = i;
            }
        }
        
        out.println(argmin-K+2);
        out.flush();
    }
    
    private static void printIntArray(int[] a) {
        for (int i: a) System.out.print(i + " ");
        System.out.println();
    }
}
