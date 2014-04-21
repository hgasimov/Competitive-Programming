/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

/**
 * SRM 597 (DIV 2)
 * 
 * @author huseyngasimov
 */
public class LittleElephantAndDouble {
    
    public static String getAnswer(int[] A) {
        int r = root(A[0]);
        for (int x : A) 
            if (r != root(x)) return "NO";
        
        return "YES";
    }
    
    
    private static int root(int x) {
        int y = x ;
        while (y % 2 == 0) y /= 2;
        return y;
    }
    
    public static void main(String[] args) {
        int[] A = {4};
        println(getAnswer(A));
    }
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
