package codeforces;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Codeforces Round #243 (Div. 2), Problem C
 */
public class SerejaandSwaps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            k = in.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        
        PriorityQueue<Integer> pq_in = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq_out = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        
        int max_sum = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++)
            for (int right = left; right < n; right++) {
                pq_in.clear();
                pq_out.clear();
                for (int i = 0; i < n; i++)
                    if (left <= i && i <= right)
                        pq_in.add(a[i]);
                    else
                        pq_out.add(a[i]);
                                
                for (int i = 0; i < k && !pq_out.isEmpty() && pq_in.peek() < pq_out.peek(); i++) {
                    pq_in.poll();
                    pq_in.add(pq_out.poll());
                }
                
                int sum = 0;
                for (int i : pq_in) sum += i;
                max_sum = Math.max(max_sum, sum);
            }
                
        out.println(max_sum);
        out.flush();
    }
}
