package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 *  Codeforces Round #242 (Div. 2), Problem C
 */
public class MagicFormulas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int sum1 = in.nextInt();
        for (int i = 1; i < n; i++)
            sum1 ^= in.nextInt();
        
        int[] sum = new int[n+1];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i-1] ^ i;
        
        int sum2 = 0;
        for (int i = 2; i <= n; i++) {
            int core = (n / i) % 2 == 0 ? 0 : sum[i-1];
            int add = sum[n % i];
            
            sum2 ^= core ^ add;
        }
         
        out.println(sum1 ^ sum2);
        out.flush();
    }
}
