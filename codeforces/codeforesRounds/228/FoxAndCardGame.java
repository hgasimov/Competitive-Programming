package codeforces;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Codeforces Round #228 (Div 2)
 * (does not pass all the system tests)
 */
public class FoxAndCardGame {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int N = in.nextInt();        
        Deck[] x = new Deck[N];        
        PriorityQueue<Index> topMaxPQ = new PriorityQueue<Index>();
        PriorityQueue<Index> bottomMaxPQ = new PriorityQueue<Index>();
        
        for (int i = 0; i < N; i++) {      
            int si = in.nextInt();
            
            int[] c = new int[si];
            for (int j = 0; j < si; j++)
                c[j] = in.nextInt();
            
            x[i] = new Deck(c);            
            
            topMaxPQ.add(new Index(i, c[0]));
            bottomMaxPQ.add(new Index(i, c[si-1]));
        }
        
        int ciel = 0;
        int jiro = 0;
        
        while (topMaxPQ.size() > 0 || bottomMaxPQ.size() > 0) {
            ciel += remove(topMaxPQ, x, true);
            jiro += remove(bottomMaxPQ, x, false);
        }
        
        
        out.println(ciel + " " + jiro);
        out.flush();        
    }
    
    private static int remove(PriorityQueue<Index> pq, Deck[] x, boolean removeFromTop) throws Exception {
        if (pq.size() <= 0) return 0;
        
        int i = pq.poll().i;
        int sum = 0;
        
        // if the chosen pile is empty try another piles
        while (x[i].isEmpty() && pq.size() > 0) {
            i = pq.poll().i;
        }
        
        // if the card has not been taken by another player
        if (!x[i].isEmpty()) {
            sum = (removeFromTop) ? x[i].removeFromTop() : x[i].removeFromBottom();            
            
            // if there're still cards in this pile
            if (!x[i].isEmpty()) {
                int tmp = (removeFromTop) ? x[i].top() : x[i].bottom();
                pq.add(new Index(i, tmp));
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
    
    private static class Deck {
        private int[] a;
        private int N, i, j;
        
        public Deck(int[] a) {
            this.a = a;
            N = a.length;
            i = 0;
            j = N-1;
        }
        
        public boolean isEmpty() {
            return i > j;
        }
        
        public int top() throws Exception {
            if (isEmpty()) throw new Exception("Deck is empty");
            return a[i];
        }
        
        public int bottom() throws Exception {
            if (isEmpty()) throw new Exception("Deck is empty");
            return a[j];
        }
        
        public int removeFromTop() throws Exception {
            if (isEmpty()) throw new Exception("Deck is empty");
            return a[i++];
        }
        
        public int removeFromBottom() throws Exception {
            if (isEmpty()) throw new Exception("Deck is empty");
            return a[j--];
        }
    }
}
