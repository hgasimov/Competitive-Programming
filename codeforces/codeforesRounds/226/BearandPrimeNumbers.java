package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Codeforces Round #226 (Div. 2), Problem C
 */
public class BearandPrimeNumbers {
    private static final int TenTo7 = 10000000;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);                
        
        int n = in.nextInt();
                        
        int[] count = new int[TenTo7 + 1];
        for (int i = 0; i < n; i++)
            count[in.nextInt()]++;
        
        boolean[] prime = primes(TenTo7+1);
        
        int[] fp = new int[TenTo7 + 1];
        for (int i = 2; i <= TenTo7; i++)
            if (prime[i]) {
                for (int j = i; j <= TenTo7; j += i)
                    fp[i] += count[j];
            }
        
        for (int j = 3; j <= TenTo7; j++)
            fp[j] += fp[j-1];
        
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int li = in.nextInt(),
                ri = Math.min(in.nextInt(), TenTo7);
            
            out.println(li <= ri ? fp[ri] - fp[li - 1] : 0);
        }
        
        out.flush();
    }
    
    // Sieve of Eratosthenes
    private static boolean[] primes(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        
        prime[0] = prime[1] = false;
        
	int nsqrt = (int) Math.sqrt (n);
        for (int i = 2; i <= nsqrt; i++)
            if (prime[i])
                for (int j=i*i; j<=n; j+=i)
                    prime[j] = false;        
        
        return prime;
    }    
}
