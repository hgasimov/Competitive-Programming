package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Good Bye 2013 (the last codeforces contest of 2013)
 * @author huseyngasimov
 */
public class NewYearRatingsChange {
    private static final Comparator<int[]> BY_RATING = new IntArray_Comparator(1);
    private static final Comparator<int[]> BY_ID = new IntArray_Comparator(0);
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);        
        int n = in.nextInt();        
        int[][] a = new int[n][2];                 
        for (int i = 0; i < n; i++) {
            a[i][0] = i;
            a[i][1] = in.nextInt();     
        }
        
        Arrays.sort(a, BY_RATING);        
        
        int max = 0;
        for (int i = 0; i < n; i++) 
            if (a[i][1] > max) {
                max = a[i][1];
            }
            else {
                a[i][1] = ++max;
            }
        
        Arrays.sort(a, BY_ID);
        printArray(a, out);
        
        out.flush();
    }
    
    private static class IntArray_Comparator implements Comparator<int[]> {
        private int index = 0;
        
        IntArray_Comparator() {}
        IntArray_Comparator(int index) { this.index = index; }
        
        @Override
        public int compare(int[] t1, int[] t2) {
            return t1[index] - t2[index];
        }        
    }    
    
    private static void printArray(int[][] a, PrintWriter out) {
        out.print(a[0][1]);
        for (int i = 1; i < a.length; i++) 
            out.print(" " + a[i][1]); 
        
        out.println();
    }
}
