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
public class InnaPinkPony {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        //n, m, i, j, a, b
        int n = in.nextInt();
        int m = in.nextInt();                
        int i = in.nextInt();
        int j = in.nextInt();                
        int a = in.nextInt();
        int b = in.nextInt();                

        int ilow = i-1;
        int ihigh = n-i;
        int jlow = j-1;
        int jhigh = m-j;
        
        if ((ilow + jlow == 0) || (ilow + jhigh == 0) || 
                (ihigh + jlow == 0) || (ihigh + jhigh == 0)) { // if you're already at some corner
            out.println(0);
        }
        else if ((ilow < a && ihigh < a) ||
                (jlow < b && jhigh < b)) { // if you can move
            out.println("Poor Inna and pony!");        
        }
        else {
            int min = Integer.MAX_VALUE;
            boolean found = false;
            int tmp = calcCornerS(ilow, jlow, a, b);
            if (tmp >= 0) { min = Math.min(min, tmp); found = true; }

            tmp = calcCornerS(ilow, jhigh, a, b);
            if (tmp >= 0) { min = Math.min(min, tmp); found = true; }

            tmp = calcCornerS(ihigh, jlow, a, b);
            if (tmp >= 0) { min = Math.min(min, tmp); found = true; }

            tmp = calcCornerS(ihigh, jhigh, a, b);
            if (tmp >= 0) { min = Math.min(min, tmp); found = true; }

            if (found) out.println(min);
            else out.println("Poor Inna and pony!");
        }
        
        out.flush();
    }
    
    private static int calcCornerS(int i, int j, int a, int b) {
        if (i % a != 0 || j % b != 0) return -1;
        int is = i / a;
        int js = j / b;
        if ((is + js) % 2 != 0) return -1;
        return Math.max(is, js);
    }
}
