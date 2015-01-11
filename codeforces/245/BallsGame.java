package codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Codeforces Round #245 (Div. 2), Problem B
 */
public class BallsGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            k = in.nextInt(),
            x = in.nextInt();
        
        List<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            c.add(in.nextInt());
        
        int max = 0;
        for (int i = 1; i < n-1; i++) 
            if (c.get(i) == x && c.get(i) == c.get(i-1)) {
                List<Integer> copy = new ArrayList<Integer>(c);
                copy.add(i, x);
                max = Math.max(max, destroy(copy, x, i) - 1);
            }
            
        out.println(max);
        out.flush();
    }
    
    private static int destroy(List<Integer> c, int x, int i) {
        int sum = 0;        
        int j = i;            
        while (!c.isEmpty()) {     
            x = c.get(j);
            for (; j >= 0 && c.get(j) == x; j--);
            
            int j1 = ++j;
            for (; j1 < c.size() && c.get(j1) == x; j1++);
            
            if (j1 - j > 2) {
                for (; j < c.size() && c.get(j) == x;) {
                    c.remove(j);
                    sum++;
                }
                
                if (j == c.size()) j--;
            }
            else {
                break;
            }
       }
        
        return sum;
    }
}
