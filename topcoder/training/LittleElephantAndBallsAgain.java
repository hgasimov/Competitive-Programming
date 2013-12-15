/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

/**
 * SRM 595 DIV 2
 * @author huseyngasimov
 */
public class LittleElephantAndBallsAgain {
    public static int getNumber(String s) {
        int maxrun = 1;
        int currun = 1;
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i-1) == s.charAt(i)) {
                currun++;
                maxrun = Math.max(maxrun, currun);
            }
            else currun = 1;
        
        return s.length() - maxrun; // for now
    }
    
    public static void main(String[] args) {
        println(getNumber("RGGGBB"));
    }
    
    private static void printArray(int[] a) { for (int i: a) println(i); }
    private static void printArray(String[] a) { for (String s: a) println(s); }    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
