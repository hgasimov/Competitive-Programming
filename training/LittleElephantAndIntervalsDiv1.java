/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

//import java.util.TreeSet;
/**
 *
 * @author huseyngasimov
 */
public class LittleElephantAndIntervalsDiv1 {
    private class Range {
        int l, r;
        
        public Range(int left, int right) {l = left; r = right; }
        
        public boolean coveredBy(int left, int right) {
            return (left <= l && right >= r);
        } 
    }
    
    public long getNumber(int M, int[] L, int[] R) {
        int N = L.length;
        int[] sig = new int[M+1];
        
        for (int i = 0; i < N; i++)
            for (int j = L[i]; j <= R[i]; j++)
                sig[j] = i+1;
        
        boolean[] exists = new boolean[N+1]; 
        int count = 0;
        for (int i = 0; i < M+1; i++)
            if (sig[i] > 0 && !exists[sig[i]]) {
                exists[sig[i]] = true;
                count++;
            }
        
        return (int) Math.pow(2, count);
    }
    
    public static void main(String[] args) {
        LittleElephantAndIntervalsDiv1 intrv = new LittleElephantAndIntervalsDiv1();
        int M = 1000;
        int[] L = {47};
        int[] R = {747};
        println(intrv.getNumber(M, L, R));
    }
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
