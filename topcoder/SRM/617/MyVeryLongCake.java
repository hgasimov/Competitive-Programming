package topcoder;

import java.util.HashSet;
import java.util.Set;

/*
 * SRM 617 (div 2), 1000 point problem
 */
public class MyVeryLongCake {
    public static int cut(int n) {
        int sum = 1;
        
        Set<Integer> pf = primeFactors(n);
        int[] primes = new int[pf.size()];
        int pr_i = 0;
        
        for (int prime : pf) {
            for (long mask = 0; mask < (1 << pr_i); mask++) {
                int sgn = 1;
                int prod = prime;
            
                for (int i = 0; i < pr_i; i++)
                    if ((mask & (1 << i)) > 0) {
                        prod *= primes[i];
                        sgn *= -1;
                    }
                sum += sgn * (n/prod - 1);
            }
            
            primes[pr_i++] = prime;
        }
            
        return sum;
    }
    
    private static Set<Integer> primeFactors(int number) {
        int n = number;
        Set<Integer> factors = new HashSet<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        if (n > 1) { factors.add(n); }        
        return factors;
    }
    
    public static void main(String[] args) {
        System.out.println(cut(577007436));
    }
}
