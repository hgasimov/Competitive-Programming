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
public class ValeraPlates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);        
        int n = in.nextInt();
        int m = in.nextInt(); // bowls
        int k = in.nextInt(); // plates
        
        int dish1 = 0, dish2 = 0;
        for (int i = 0; i < n; i++) {
            if (in.nextInt() == 1) dish1++; else dish2++;
        }

        int min_dish1_bowl = Math.min(dish1, m);
        dish1 -= min_dish1_bowl; 
        m -= min_dish1_bowl;
        
        int min_dish2_plate = Math.min(dish2, k);
        dish2 -= min_dish2_plate;
        k -= min_dish2_plate;
        
        if (m > 0 && dish2 > 0) {
            dish2 -= Math.min(dish2, m);
        }
        
        out.println(dish1 + dish2);
        out.flush();
    }
}
