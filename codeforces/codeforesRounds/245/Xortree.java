package codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Codeforces Round #245 (Div. 2), Problem C
 */
public class Xortree {
    private static List<Integer>[] adj;
    private static int[] init;
    private static int[] goal;
    private static List<Integer> picked = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        
        adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();

        for (int i = 0; i < n-1; i++) {
            int ui = in.nextInt() - 1;
            int vi = in.nextInt() - 1;
            adj[ui].add(vi);
            adj[vi].add(ui);
        }
        
        init = new int[n];
        for (int i = 0; i < n; i++)
            init[i] = in.nextInt();
        
        goal = new int[n];
        for (int i = 0; i < n; i++)
            goal[i] = in.nextInt();
       
        
        out.println(solve(0, -1, false, false));
        for (int i : picked)
            out.println(i+1);
        out.flush();
    }
    
    private static int solve(int j, int parent, boolean f0, boolean f1) {
        int flipped = 0;
        if (f0) init[j] ^= 1;
        
        if (init[j] != goal[j]) {;
            flipped++;
            f0 = !f0;
            picked.add(j);            
        }
        
        for (int i : adj[j])
            if (i != parent)
                flipped += solve(i, j, f1, f0);
        
        return flipped;
    }
}
