package codeforces;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Codeforces Round #232 (Div. 2), Problem C
 */
public class OnNumberofDecompositionsintoMultipliers { 
    private static long[] prodCache;
    private static long m = 1000000007;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        if (n == 1) {
            out.println(1);            
        }
        else {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();

            Map<Integer, Integer> divs = new HashMap<>();
            for (int i = 0; i < a.length; i++)
                addDivs(a[i], divs);

            int maxVal = getMax(divs.values());
            prodCache = new long[n + maxVal];
            prodCache[0] = prodCache[1] = 1;
            for (int i = 2; i < n+maxVal; i++) {
                prodCache[i] = prodCache[i-1] * i % m;            
            }

            long prod = 1;            
            for (int i : divs.values())                        
                prod = prod * comb(n+i-1, n-1) % m;

            out.println(prod);
        }
        out.flush();
    }    
    
    private static void addDivs(int num, Map<Integer, Integer> divs) {
        while(num > 1) {
            boolean found = false;
            int max = (int)Math.ceil(Math.sqrt(num));            
            for (int div = 2; div <= max; div++)
                if (num % div == 0) {
                    num /= div;
                    addDiv(div, divs);
                    found = true;
                    break;
                }
            
            if(!found) {
                addDiv(num, divs);
                break;
            }
        }
    }
    
    private static void addDiv(int div, Map<Integer, Integer> divs) {
        divs.put(div, divs.containsKey(div) ? divs.get(div)+1 : 1);                   
    }
   
    private static long inverse(long n) {
        BigInteger bi = new BigInteger(String.valueOf(n));
        return Long.parseLong(bi.modInverse(new BigInteger(String.valueOf(m))).toString());
    }
    
    private static long comb(int n, int k) {
        if (k == 0 || k == n) return 1;
        long denom = prodCache[k] * prodCache[n-k] % m;
        return prodCache[n] * inverse(denom) % m;
    }   
    
    private static int getMax(Collection<Integer> col) {
        int max = 0;
        for (int i : col)
            max = Math.max(i, max);
        return max;
    }
}
