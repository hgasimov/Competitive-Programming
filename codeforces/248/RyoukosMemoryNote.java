package codeforces;

import java.io.PrintWriter;
import java.util.*;

/*
 * Codeforces Round #248 (Div. 2), Problem C
 */
public class RyoukosMemoryNote {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            m = in.nextInt();        
        int[] a = readArray(in, m);

        out.println(solve(a, n, m));
        out.flush();
    }
    
    private static long solve(int[] a, int n, int m) {
        if (n == 1 || m < 3) return 0;
        
        Map<Integer, List<Integer>> pages = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!pages.containsKey(a[i])) pages.put(a[i], new ArrayList<Integer>());
            List<Integer> pageAdj = pages.get(a[i]);
            if (i > 0 && a[i] != a[i-1]) pageAdj.add(a[i-1]);
            if (i < a.length - 1  && a[i] != a[i+1]) pageAdj.add(a[i+1]);
        }
        
        long mindiff = 0;
        for (int k : pages.keySet()) {
            List<Integer> x = pages.get(k);
            if (x.isEmpty()) continue;
            long sum_orig = calcSum(x, k);
            
            Collections.sort(x);
            int mid = x.size() / 2;
            long sum_new = calcSum(x, x.get(mid));
            if (x.size() > 1) sum_new = Math.min(sum_new, calcSum(x, x.get(mid-1)));
            mindiff = Math.min(mindiff, sum_new - sum_orig);
        }
        
        long sum = 0;
        for (int i = 1; i < a.length; i++)
            sum += Math.abs(a[i] - a[i-1]);

        return sum + mindiff;
    }
    
    private static long calcSum(List<Integer> x, int k) {
        long sum = 0;
        for (int i : x)
            sum += Math.abs(i - k);
        return sum;
    }

    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
}
