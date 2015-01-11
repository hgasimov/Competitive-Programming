package codeforces;

import java.io.PrintWriter;
import java.util.*;

/*
 * Codeforces Round #244 (Div. 2), Problem C
 */
public class Checkposts {
    private static final long mod = 1000000007;
    private static long minCost = 0;
    private static long numWays = 1;
    private static int[] cost;    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        cost = readArray(in, n);
        
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int ui = in.nextInt() - 1,
                vi = in.nextInt() - 1;
            adj[ui].add(vi);
        }
        
        boolean marked[] = new boolean[n];
        List<Integer>[] rvAdj = reverse(adj);
        Deque<Integer> dfOrder = dfOrder(rvAdj);
        for (int j : dfOrder)
            if (!marked[j]) {
                updateParamsDFS(j, adj, marked);
            }

        out.format("%d %d\n", minCost, numWays);
        out.flush();
    }
    
    private static void updateParamsDFS(int start, List<Integer>[] adj, boolean[] marked) {
        int mc = Integer.MAX_VALUE;
        int nMin = 1;
        Deque<Integer> st = new ArrayDeque<>();
                
        st.push(start);
        marked[start] = true;
        while(!st.isEmpty()) {
            int j = st.pop();
            if (cost[j] < mc) {
                mc = cost[j];
                nMin = 1;
            }
            else if (cost[j] == mc) {
                nMin++;
            }
            
            for (int i : adj[j])
                if (!marked[i]) {
                    marked[i] = true;
                    st.push(i);
                }
        }
        
        minCost += mc;
        numWays = (numWays * nMin) % mod;
    }
    
    
    private static Deque<Integer> dfOrder(List<Integer>[] adj) {
        int n = adj.length;
        boolean[] marked = new boolean[n];
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            if (!marked[i])
                dfOrder(i, marked, order, adj);
        return order;
    }
    
    private static void dfOrder(int i, boolean[] marked, Deque<Integer> order, List<Integer>[] adj) {                        
        marked[i] = true;            
        for (Integer j : adj[i])
            if (!marked[j]) {                
                dfOrder(j, marked, order, adj);
            }
        order.push(i);
    }
    
    private static List<Integer>[] reverse(List<Integer>[] adj) {
        int n = adj.length;
        List<Integer>[] rev = new ArrayList[n];
        for (int i = 0; i < n; i++)
            rev[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
            for (int j : adj[i])
                rev[j].add(i);
        
        return rev;
    }

    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
}
