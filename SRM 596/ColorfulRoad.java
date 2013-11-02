/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

import java.util.ArrayList;

/**
 *
 * @author huseyngasimov
 */
public class ColorfulRoad {
    
    public static int getMin(String road) {
        if (road.length() < 2) return -1;
        int N = road.length();
        int [] cost = new int[N];
        
        cost[N-1] = 0;                
        
        for (int i = N-2; i >= 0; i--) {           
                        
            char thisChar = road.charAt(i);
            char lookChar = 'a';
            if (thisChar == 'R') lookChar = 'G';
            else if (thisChar == 'G') lookChar = 'B';
            else lookChar = 'R';
            
            int minCost = -1;
            for (int j = i; j < N; j++) {
                if (road.charAt(j) == lookChar && cost[j] > -1) {
                    int cst = (int) Math.pow(j - i, 2) + cost[j];
                    if (minCost == -1 || cst < minCost) minCost = cst;                    
                }
            }
            
            cost[i] = minCost;
        }
        
        
        return cost[0];
    }
    
    public static void main(String[] args) {
        String road = "RBRGBGBGGBGRGGG";
        println(getMin(road));
    }
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
