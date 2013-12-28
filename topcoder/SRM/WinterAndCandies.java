package topcoder;

import java.util.Arrays;

/**
 * SRM 601 (DIV 2)
 * @author huseyngasimov
 */
public class WinterAndCandies {
    public static int getNumber(int[] type) {
        int N = type.length;
        Arrays.sort(type);
        long niter = (long) Math.pow(2, N);
        
        int sum = 0;
        for (long mask = 1; mask < niter; mask++) {
            int K = Long.bitCount(mask);
            int prev_i = -1; 
            boolean countit = true;
            for (int i = 0; i < N; i++)
                if (isSet(mask, i)) {                    
                    if (type[i] > K) {countit = false; break;} 
                    if (i > 0 && prev_i > -1 && type[i] == type[prev_i]) {countit = false; break;}
                    prev_i = i;
                }
            
            if (countit) sum++;
        }
    
        return sum;
    }
    
    private static boolean isSet(long l, int i) {
        long mask = (long) 1 << i;
        l = l & mask;
        return l != 0;
    }
    
    public static void main(String[] args) {
        int[] type = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        println(getNumber(type));
    }
    
    private static void println(Object o) { System.out.println(o);}
}
