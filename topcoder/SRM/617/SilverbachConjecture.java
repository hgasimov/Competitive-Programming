package topcoder;

/*
 * SRM 617 (div 2), 250 point problem
 */
public class SilverbachConjecture {
    public static int[] solve(int n) {
        if (n < 8) return null;        
        int[] res = new int[2];
        
        for (int i = 4; i < n; i++)
            if ((!isPrime(i)) && (!isPrime(n-i))) {
                res[0] = i;
                res[1] = n-i;
                return res;
            }
        
        return null;
    }
    
    private static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x == 2) return true;
        int max = (int) Math.sqrt(x);
        for (int i = 2; i <= max; i++)
            if (x % i == 0) return false;
        return true;
    }
}
