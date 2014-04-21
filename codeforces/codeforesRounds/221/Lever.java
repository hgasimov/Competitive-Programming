/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #221 (DIV 2)
 * @author huseyngasimov
 */
public class Lever {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);        
        
        String s = in.next();
        int pivot = s.indexOf("^");
       
        long left = 0;
        int i = 0;
        for (; s.charAt(i) != '^'; i++) {
            char c = s.charAt(i);
            if (c > '0' && c <= '9') {
                left += (pivot - i) * (c - '0');
            }
        }
        
        long right = 0;
        for (i = pivot + 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > '0' && c <= '9') {
                right += (i - pivot) * (c - '0');
            }
        }
        
        if (left > right) out.println("left");
        else if (right > left) out.println("right");
        else out.println("balance");
        
        out.flush();
    }
}
