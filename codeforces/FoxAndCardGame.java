package codeforces;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Codeforces Round #228 (Div 2)
 * (does not pass all the system tests)
 */
public class FoxAndCardGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();        
        Object[] x = new Object[N];       
        int[][] ends = new int[N][2];        
        PriorityQueue<Index> topMaxPQ = new PriorityQueue<Index>();
        PriorityQueue<Index> bottomMaxPQ = new PriorityQueue<Index>();
        
        for (int i = 0; i < N; i++) {      
            int si = in.nextInt();
            ends[i][1] = si - 1;
            
            int[] c = new int[si];
            for (int j = 0; j < si; j++)
                c[j] = in.nextInt();
            
            x[i] = c;            
            
            topMaxPQ.add(new Index(i, c[0]));
            bottomMaxPQ.add(new Index(i, c[si-1]));
        }
        
        int ciel = 0;
        int jiro = 0;
        
        while (topMaxPQ.size() > 0 || bottomMaxPQ.size() > 0) {
            ciel += remove(topMaxPQ, x, ends, 0);
            jiro += remove(bottomMaxPQ, x, ends, 1);
        }
        
        
        out.println(ciel + " " + jiro);
        out.flush();        
    }
    
    private static int remove(PriorityQueue<Index> pq, Object[] x, int[][] ends, int j) {
        if (pq.size() <= 0) return 0;
        Index max = pq.poll();
        
        int i = max.i;
        int sum = 0;
        
        // if the chosen pile is empty try another piles
        while (ends[i][0] > ends[i][1] && pq.size() > 0) {
            max = pq.poll();
            i = max.i;
        }
        
        // if the card has not been taken by another player
        if (ends[i][0] <= ends[i][1]) {
            sum = max.val;    
            
            int newEnd = (j == 0) ? ++ends[i][0] : --ends[i][1];
            
            // if there're still cards in this pile
            if (ends[i][0] <= ends[i][1]) {
                int[] c = (int[]) x[i];
                pq.add(new Index(i, c[newEnd]));
            }
        }
        
        return sum;
    }
    
    private static class Index implements Comparable<Index> {
        int i, val;
        Index(int i, int val) {
            this.i = i;
            this.val = val;
        }
        
        @Override
        public String toString() {
            return i + ", " + val;
        }

        @Override
        public int compareTo(Index t) {
            return t.val - this.val;
        }
    }
}
