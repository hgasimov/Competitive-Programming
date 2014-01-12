package codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Codeforces Round #223 (Div. 2)
 */
public class SerejaandStairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt();
        int[] cards = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = in.nextInt();

        Arrays.sort(cards);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        
        int i = N-1;
        i = skip(cards, i);
        
        int num = 0;
        num++; 
        list.add(cards[i]);
        i--; // biggest card
        
        while (i >= 0) {
            num++; 
            list.add(cards[i]);
            
            if (i > 0 && cards[i] == cards[i-1]) {
                num++;
                list.add(0, cards[i-1]);
            }
            
            i = skip(cards, i);
            i--;
        }
        
        out.println(num);
        for (Integer card: list) out.print(card + " ");        
        
        out.flush();
    }
    
    private static int skip(int[] cards, int i) {
        while(i > 0 && cards[i] == cards[i-1]) i--;
        return i;
    }
}
