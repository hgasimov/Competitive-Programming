/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #215 (Div. 2)
 * @author huseyngasimov
 */
public class SerejaAlgorithm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        String s = in.next(); 
        int N = s.length();
        int[][] a = new int[N+1][3];
        for (int i = 0; i < N; i++) {             
            System.arraycopy(a[i], 0, a[i+1], 0, 3);
            if (s.charAt(i) == 'x') a[i+1][0] = a[i][0] + 1;
            else if (s.charAt(i) == 'y') a[i+1][1] = a[i][1] + 1;
            else a[i+1][2] = a[i][2] + 1;
        }
                
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int li = in.nextInt();
            int ri = in.nextInt();
            if (ri - li < 2) {
                out.println("YES");
            }
            else {
                int numx = a[ri][0] - a[li-1][0]; 
                int numy = a[ri][1] - a[li-1][1];
                int numz = a[ri][2] - a[li-1][2];

                if (Math.abs(numx-numy) > 1) out.println("NO");
                else if (Math.abs(numx-numz) > 1) out.println("NO");
                else if (Math.abs(numy-numz) > 1) out.println("NO");
                else out.println("YES");
            }
        }
        out.flush();
    }    
}
