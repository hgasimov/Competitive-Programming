package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #222 (Div. 2) 
 * @author huseyngasimov
 */
public class PlayingwithDice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int a = in.nextInt();
        int b = in.nextInt();
        
        int[] res = new int[3];
        for (int i = 1; i <= 6; i++) {
            int first = Math.abs(a-i);
            int second = Math.abs(b-i);
            if (first < second) res[0]++;
            else if (second < first) res[2]++;
            else res[1]++;
        }         
            
        out.println(res[0] + " " + res[1] + " " + res[2]);
        out.flush();
    }
}
