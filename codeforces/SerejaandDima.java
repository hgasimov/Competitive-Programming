package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #223 (Div. 2)
 */
public class SerejaandDima {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();
        int[] cards = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = in.nextInt();
        
        int i = 0, j = N-1;
        int serj = 0, dim = 0; 
        boolean serj_turn = true;
        while(i <= j) {
            int max = cards[i] > cards[j] ? cards[i++] : cards[j--];
            
            if (serj_turn) {
                serj += max;
            }
            else {
                dim += max;
            }
            
            serj_turn = !serj_turn;
        }
       
        out.println(serj + " " + dim);
        out.flush();
    }
}
