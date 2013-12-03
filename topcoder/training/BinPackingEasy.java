/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author huseyngasimov
 */
public class BinPackingEasy {
    private static final Comparator<int[]> ARRAY_COMPARE = new ArrayCompare();
    private static int maxSize = 300;
    
    public static int minBins(int[] item) {
        int N = item.length;
        PriorityQueue<int[]> couples = new PriorityQueue<int[]>((N*N+1)/2, ARRAY_COMPARE);
        
        for (int i = 0; i < N-1; i++)
            for (int j = i+1; j < N; j++)
                if (item[i] + item[j] <= maxSize) {
                    int[] a = {i, j, item[i] + item[j]};
                    couples.add(a);
                }
        
        boolean[] marked = new boolean[N];
        int nmarked = 0;
        int[] a = null;        
        while ((a = couples.poll()) != null)
            if (!(marked[a[0]]) && !(marked[a[1]])) {
                marked[a[0]] = true; 
                marked[a[1]] = true;
                nmarked += 2;
            }
        
        return nmarked/2 + N - nmarked;
    }
    
    public static void main(String[] args) {
        int[] a = {123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198};
        System.out.println(minBins(a));
    }
    
    private static class ArrayCompare implements Comparator<int[]> {

        @Override
        public int compare(int[] t, int[] t1) {
            return ((Integer)(t1[2])).compareTo(t[2]); // bigger comes first
        }
        
    } 
}
