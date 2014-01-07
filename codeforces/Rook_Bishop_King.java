package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #217 (Div. 2)
 */
public class Rook_Bishop_King {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int r1 = in.nextInt();
        int c1 = in.nextInt();                
        int r2 = in.nextInt();
        int c2 = in.nextInt();                

        out.println(rook(r1, c1, r2, c2) + " "
                + bishop(r1, c1, r2, c2) + " "
                + king(r1, c1, r2, c2));
        out.flush();
    }
    
    private static int rook(int r1, int c1, int r2, int c2) { 
        if (r1 == r2 || c2 == c1) 
            return 1;
        else 
            return 2; 
    }
    
    private static int bishop(int r1, int c1, int r2, int c2) {
        int rb = Math.abs(r1 - r2) % 2 == 0 ? 1:0; 
        int cb = Math.abs(c1 - c2) % 2 == 0 ? 1:0;
        if ((rb + cb) % 2 == 0) {
            if (Math.abs(r1 - r2) == Math.abs(c1 - c2))
                return 1;
            else
                return 2; 
        }
        else 
            return 0;
    }
    
    private static int king(int r1, int c1, int r2, int c2) { 
        return Math.max(Math.abs(r1 - r2), Math.abs(c1 - c2)); 
    }
}
