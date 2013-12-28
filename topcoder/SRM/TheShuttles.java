/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

/**
 * SRM 600 (Div 2)
 * @author huseyngasimov
 */
public class TheShuttles {
    public static int getLeastCost(int[] cnt, int baseCost, int seatCost) {
        int maxCnt = max(cnt);
        int minCost = Integer.MAX_VALUE;
        
        for (int nseat = maxCnt; nseat >= 1; nseat--) {
            int sum = 0;
            for (int j : cnt) {
                int nBus = (int) Math.ceil((double)j / nseat);
                sum += (baseCost + nseat * seatCost) * nBus;
            }
            
            minCost = Math.min(minCost, sum);
        }
        
        return minCost;
    }

    public static void main(String[] args) {
        int[] cnt =  {51, 1, 77, 14, 17, 10, 80};
        println(getLeastCost(cnt, 32, 40));
    }
    
    private static int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) max = i > max ? i:max;
        return max;
    }
    
    private static void printArray(int[] a) { for (int i: a) println(i); }
    private static void printArray(String[] a) { for (String s: a) println(s); }    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
