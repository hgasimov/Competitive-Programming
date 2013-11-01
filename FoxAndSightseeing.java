/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

/**
 *
 * @author huseyngasimov
 */
public class FoxAndSightseeing {
    
    public static int getMin(int[] position) {
        int mindist = Integer.MAX_VALUE;
        for (int skip = 1; skip < position.length-1; skip++) {
            int dist = calcDistance(position, skip);
            if (dist < mindist) mindist = dist;            
        }
        return mindist;
    }
    
    private static int calcDistance(int[] position, int skip) {
        int dist = 0; int N = position.length;
        int prev = position[0];
        for (int i = 1; i < N; i++) {
            if (i == skip) continue;           
            dist += Math.abs(position[i] - prev);
            prev = position[i];
        }
        
        //println(skip + ": " + dist);
        
        return dist;
    }
    
    public static void main(String[] args) {
        int[] position = {2,-3,5,7,-11,-13,17,-19,23,29,-31,-37,-41,43,-47,-53,-59,61,-67,71};
        println(getMin(position));
    }
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
