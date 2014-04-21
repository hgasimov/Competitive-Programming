package codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/** 
 * Codeforces Round #224 (Div. 2) 
 */
public class ArithmeticProgression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();
        long[] cards = new long[N];
        
        for (int i = 0; i < N; i++)
            cards[i] = in.nextLong();
        
        if (N < 2) {
            out.println(-1);
        }
        else {
            Arrays.sort(cards);                        
            
            ArrayList<Long> res1 = new ArrayList<Long>();;          
            long dif = cards[1] - cards[0];
            
            if (dif > 1 && dif % 2 == 0) {
                long incr = dif / 2;
                cards[0] += incr;
                ArrayList<Long> tmp = progression(cards, dif/2, false);
                
                if (tmp.size() > 0) res1.add(cards[0]);
                
                cards[0] -= incr;
            }
            
            ArrayList<Long> res2 = progression(cards, dif, true);
            long[] res = new long[res1.size() + res2.size()];
            int i = 0;
            for (long l: res1) res[i++] = l;                
            for (long l: res2) res[i++] = l;
            
            
            Arrays.sort(res);
            out.println(res.length);
            for (long l: res) out.print(l + " ");
        }
        
        
        out.flush();
    }
    
    private static ArrayList<Long> progression(long[] cards, long dif, boolean isprog) {
        int N = cards.length;
        ArrayList<Long> res = new ArrayList<Long>();

        for (int i = 1; i < N; i++) {
            long cmp = cards[i] - cards[i-1] - dif;
            //println(cards[i-1] + " " + cards[i] + " " + dif + " " + isprog);
            if ((cmp != 0) && (!isprog)) return new ArrayList<Long>();
            
            if (cmp > 0) {
                if (isprog) {
                    isprog = false;
                    cards[i-1] += dif;
                    res.add(cards[i-1]); //println("added " + cards[i-1]);
                    i--;
                }
                else {
                    return new ArrayList<Long>();
                }
            }
            else if (cmp < 0) {
                return new ArrayList<Long>();
            }                
        }

        
        if (isprog) {
            res.add(cards[0] - dif);
            if (dif > 0) res.add(cards[N-1] + dif);
        }
        else if (res.size() < 1) {
            res.add(cards[0]);
        }
        
        return res;
    }
       
    private static void println(Object o) { System.out.println(o);}
}
