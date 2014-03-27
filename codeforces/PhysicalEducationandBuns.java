package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #231 (Div. 2), Problem D
 */
public class PhysicalEducationandBuns {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();                
        int[] h = new int[n];
        for (int i = 0; i < n; i++)
            h[i] = in.nextInt();
        
        if (n < 2) { return; }
        else if (n == 2) {
            out.println(0);
            out.println(Math.min(h[0], h[1]) + " " + Math.abs(h[0] - h[1]));
            out.flush();
            return;
        }
        
        Arrays.sort(h);
        
        int maxSlope_i = maxSlope(h);
        int minSlope_i = minSlope(h);
                
        for (int max = 0; ; max++) {
            double minSlopeStep1 = ((double)(h[minSlope_i] + 2*max - h[0]))/minSlope_i;
            double minSlopeStep2 = ((double)(h[minSlope_i] - h[0]))/minSlope_i;
            
            if (h[0] + maxSlope_i * minSlopeStep1 - h[maxSlope_i] < 0
		&& h[0] + 2*max + maxSlope_i * minSlopeStep2 - h[maxSlope_i] < 0) continue;
            
            main:
            for (int low1st = h[0] - max; low1st <= h[0] + max; low1st++) {
                for (int low2nd = h[1] + max; low2nd >= h[1] - max; low2nd--) {
                    int step = low2nd - low1st;
                    if (step < 0) break;
                    
                    int works = works(h, low1st, step, max, maxSlope_i);
                    if (works < 0) continue main;
                    if (works == 0) {
                        out.println(max);
                        out.println(low1st + " " + step);
                        out.flush();
                        return;
                    }
                }
            }
        }
    }
    
    private static int works(int[] h, int low1st, int step, int max, int maxSlope_i) {
        if (low1st + maxSlope_i * step + max - h[maxSlope_i] < 0) return -1;
        
        int curHeight = low1st + step * h.length;
        for (int i = h.length-1; i > 0; i--) {
            curHeight -= step;
            if (Math.abs(h[i] - curHeight) > max) return curHeight + max - h[i];
        }
        
        return 0;
    }
    
    private static int maxSlope(int[] h) {
        int maxSlope_i = 1;
        double maxSlope = (double)h[1] - (double)h[0];
        for (int i = 2; i < h.length; i++)
            if (((double)h[i] - (double)h[0])/i > maxSlope) {
                maxSlope_i = i;
                maxSlope = ((double)h[i] - (double)h[0])/i;
            }
        
        return maxSlope_i;
    }
    
    private static int minSlope(int[] h) {
        int minSlope_i = 1;
        double minSlope = (double)h[1] - (double)h[0];
        if (minSlope == 0) minSlope = 0.00000001;
        
        for (int i = 2; i < h.length; i++) {
            double slope = (h[i] == h[0]) ? 0.00000001 / i : ((double)h[i] - (double)h[0])/i;
            if (slope < minSlope) {
                minSlope_i = i;
                minSlope = slope;
            }
        }
        
        return minSlope_i;
    }
}

