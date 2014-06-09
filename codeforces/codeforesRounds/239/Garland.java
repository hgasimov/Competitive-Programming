package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #239 (Div. 2), Problem B
 */
public class Garland {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        String papers = in.next();
        String garland = in.next();                
        out.println(solve(count(papers), count(garland)));
        out.flush();
    }
    
    private static int solve(int[] count_p, int[] count_g) {
        int sum = 0;
        for (int i = 0; i < 'z'-'a'+1; i++) {
            if (count_p[i] == 0 && count_g[i] == 0) continue;
            if (count_p[i] == 0 && count_g[i] > 0) return -1;
            sum += Math.min(count_p[i], count_g[i]);
        }
        
        return sum;
    }
    
    private static int[] count(String s) {
        int[] count = new int['z'-'a'+1];        
        for (char c : s.toCharArray()) count[c-'a']++;
        return count;
    }
}
