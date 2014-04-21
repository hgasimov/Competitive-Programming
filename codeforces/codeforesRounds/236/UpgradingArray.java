package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 *  Codeforces Round #236 (Div. 2), Problem D
 */
public class UpgradingArray {
    private static int[] b;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            m = in.nextInt();
        
        int[] a = readArray(in, n);        
        b = readArray(in, m);
        
        for (int i = n-1; i >= 0; i--) {
            int gcd = a[0];
            for (int j = 1; j <= i; j++)
                gcd = gcd(gcd, a[j]);
            if (f(gcd) < 0)
                for (int j = 0; j <= i; j++)
                    a[j] /= gcd;            
        }
        
        int sum = 0;
        for (int j = 0; j < n; j++)
            sum += f(a[j]);
        
        out.println(sum);
        out.flush();
    }
    
    private static int gcd(int x, int y) {
        if (x % y == 0)
		return y;
	return gcd(y, x % y);
    }
    
    private static int f(int s) {
        int sum = 0;
        int max = (int) Math.sqrt(s);
        for (int i = 2; i <= max; i++)
            if (s % i == 0) {
                boolean exists = Arrays.binarySearch(b, i) >= 0;
                while (s % i == 0) {
                    s /= i;
                    sum += exists ? - 1 : 1;
                }
                max = (int) Math.sqrt(s);
            }
        
        if (s > 1) sum += Arrays.binarySearch(b, s) >= 0 ? -1 : 1;
        return sum;
    }
    
    private static int[] readArray(Scanner in, int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = in.nextInt();
        return a;
    }
}
