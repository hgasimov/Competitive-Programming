package topcoder;

/*
 * SRM 626 (Div 2), 500 point problem
 */
public class FixedDiceGameDiv2 {
    public static double getExpectation(int a, int b) {
        int sum = 0, exp = 0;
        
        for (int i = a; i > 1; i--) {
            int k = Math.min(i-1, b);
            exp += i * k;
            sum += k;
        }
        
        return ((double) exp) / sum;
    }
}
