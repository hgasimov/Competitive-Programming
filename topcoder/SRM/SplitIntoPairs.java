package topcoder;

import java.util.Arrays;

/**
 * SRM 603 (DIV 2)
 */
public class SplitIntoPairs {
    public static int makepairs(int[] A, int X) {
        Arrays.sort(A);
        
        int N = A.length;
        boolean min1 = false;
        for (int i = 1; i < N; i += 2)
            if (A[i-1] < 0 && A[i] > 0 && (A[i-1] * A[i] < X)) 
                min1 = true;
        
        
        if (min1) return N/2 - 1;
        return N/2;
    }
    
    public static void main(String[] args) {

    }    
}
