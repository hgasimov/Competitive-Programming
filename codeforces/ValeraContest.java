/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #216 (Div. 2)
 * @author huseyngasimov
 */
public class ValeraContest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);        
        int n = in.nextInt(); // number of students
        int k = in.nextInt(); // k members
        int l = in.nextInt(); // min score
        int r = in.nextInt(); // max score
        int s_all = in.nextInt(); // total score
        int s_k = in.nextInt(); // k members' score
        
        int k_rest = n - k;
        int s_k_rest = s_all - s_k;        
        int[] k_rest_result = solve(k_rest, s_k_rest, l, r);
        
        l = k_rest_result[0];
        r = k_rest_result[1];
        int[] k_result = solve(k, s_k, l, r);
            
        printArray(k_result, 2, out);
        printArray(k_rest_result, 2, out);                
        
        out.flush();
    }
    
    private static int[] solve(int n, int sum, int min, int max) {
        if (n == 0) { int[] r = {min, max}; return r; }
        
        double avg = (double) sum / n; //println("avg = " + avg);
        if (avg < min || avg > max) return null;
        
        int[] result = new int[n+2]; //println("debug 2");

        int avg_floor = (int) Math.floor(avg);
        for (int i = 2; i < result.length; i++) result[i] = avg_floor;            

        int deficit = sum - avg_floor*n; 
        if (deficit > 0) {
            for (int i = 0; i < deficit; i++) result[i+2] = avg_floor + 1; 
            result[0] = avg_floor + 1;                
        }
        else {
            result[0] = avg_floor;
        }
            
        result[1] = max;
        
        return result;
    }
            
    private static void printArray(int[] a, int start, PrintWriter out) { 
        for (int i = start; i < a.length; i++) out.print(a[i] + " ");
    }
}
