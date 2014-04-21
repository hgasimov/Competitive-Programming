package topcoder;

import java.util.Arrays;

/* 
 * Single Round Match 608 (Div 2)
 */
public class MysticAndCandiesEasy {
    
    public static int minBoxes(int C, int X, int[] high) {
        int N = high.length;
        Arrays.sort(high);
        
        int[] candies = new int[N];
        int remains = C;
        for (int i = 0; i < N; i++) {
            if (remains >= high[i]) {
                candies[i] = high[i];
                remains -= candies[i];
            }
            else {
                candies[i] = remains;
                break;
            }
        }
        
        int sum = 0;
        for (int i = N-1; i >= 0; i--) {
            sum += candies[i];
            if (sum >= X) return N-i;
        }
            
        return -1;
    }
    
    
    public static void main(String[] args) {
        int[] high = {3, 3, 3, 3, 3};
        println(minBoxes(10, 9, high));
    }
       
    private static void println(Object o) { System.out.println(o);}
}
