package topcoder;

import java.util.Arrays;

/**
 * SRM 601 (DIV 2)
 * @author huseyngasimov
 */
public class WinterAndMandarins {
    public static int getNumber(int[] bags, int K) {
        Arrays.sort(bags);
        int min = bags[K-1]-bags[0];
        for (int i = K-1; i < bags.length; i++) {
            min = Math.min(min, bags[i] - bags[i-K+1]);
        }
        
        return min;
    }
    
    public static void main(String[] args) {
        int[] bags = {4, 6, 8, 10, 12, 14};
        println(getNumber(bags, 2));
    }
    
    private static void println(Object o) { System.out.println(o);}
}
