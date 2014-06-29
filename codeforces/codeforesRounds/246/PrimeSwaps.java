package codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Codeforces Round #246 (Div. 2), Problem C
 */
public class PrimeSwaps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();        
        int[] a = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt() - 1;
            pos[a[i]] = i;
        }
        
        boolean[] prime = primes(n);
        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (pos[i] != i) {
                int posi = pos[i],
                    posj = i;
                
                while (!prime[posi - posj + 1]) posj++;
                int j = a[posj];
                
                int tmp = a[posi];
                a[posi] = a[posj];
                a[posj] = tmp;
                
                pos[i] = posj;
                pos[j] = posi;
                
                ops.add(posj);
                ops.add(posi);
            }
        }
        
        
        out.println(ops.size() / 2);
        for (int i = 0; i < ops.size(); i += 2)
            out.format("%d %d\n", ops.get(i) + 1, ops.get(i+1) + 1);
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
