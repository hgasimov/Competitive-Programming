package codeforces;

import java.io.PrintWriter;
import java.util.*;

/*
 * Codeforces Round #234 (Div. 2), Problem D
 */
public class DimaandBacteria {
    private static class Edge implements Comparable<Edge> {
        int i, j, w;
        public Edge(int i, int j, int w) {
            this.i = i;
            this.j = j;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
        
        public int other(int k) {
            return k == i ? j : i;
        }
    }
    
    private static class Graph {
        int N;
        List<Integer>[] adj;
        int[] distTo;
        boolean[] connected;
        
        public Graph(int N) {
            this.N = N;                                    
            adj = (List<Integer>[]) new List[N];
            for (int i = 0; i < N; i++)
                adj[i] = new ArrayList<>();
        }
        
        public void addEdge(int i, int j) {
            adj[i].add(j);
            adj[j].add(i);
        }        
        
        public boolean connected(int s, int lo, int hi) {
            if (connected == null) connected = new boolean[N];
            Arrays.fill(connected, false);
            
            boolean[] localConnected = new boolean[hi-lo];
            int lConnN = 0; // number of local connections
            
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(s);
            
            while(!queue.isEmpty()) {
                Integer i = queue.remove();
                if (!connected[i]) {
                    connected[i] = true;
                    for (int j : adj[i]) {
                        if (!connected[j]) queue.add(j);
                    }
                    
                    if (i >= lo && i < hi && (!localConnected[i-lo])) {
                        localConnected[i-lo] = true;
                        lConnN++;
                        if (lConnN >= hi-lo) return true;
                    }
                }
            }
            
            return false;
        }
    }
    
    private static class WeightedGraph {
        int N;
        int[][] adj;
        
        public WeightedGraph(int N) {
            this.N = N;    
            
            adj = new int[N][N];
            for (int i = 0; i < N; i++)
                Arrays.fill(adj[i], Integer.MAX_VALUE);
            for (int i = 0; i < N; i++)
                adj[i][i] = 0;                        
        }
        
        public void addEdge(int i, int j, int w) {
            if (w < adj[i][j]) { // omit paralel edges with more edge weight                
                adj[i][j] = adj[j][i] = w;
            }
        }        
        
        // Floyd - Warshall
        public int[][] shortestPath() {
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++)
                System.arraycopy(adj[i], 0, dist[i], 0, N);            
            
            for (int k = 0; k < N; k++)
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++) 
                        if (dist[i][k] < Integer.MAX_VALUE &&
                            dist[k][j] < Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j])
                                dist[i][j] = dist[i][k] + dist[k][j];
            
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (dist[i][j] == Integer.MAX_VALUE) dist[i][j] = -1;
            
            return dist;
        }        
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);                
        
        int n = in.nextInt(),
            m = in.nextInt(),
            k = in.nextInt();
        
        int[] c = new int[k];
        for (int i = 0; i < k; i++) 
            c[i] = in.nextInt();
        
        int[] type = calcType(n, c);
        
        Graph zeroG = new Graph(n);
        WeightedGraph G = new WeightedGraph(k);
        
        for (int i = 0; i < m; i++) {
            int xi = in.nextInt() - 1;
            int yi = in.nextInt() - 1;
            int wi = in.nextInt();
            
            G.addEdge(type[xi], type[yi], wi);
            if (wi == 0)
                zeroG.addEdge(xi, yi);                
        }
        
        boolean correct = true;
        int cur = 0;

        for (int i = 0; i < k; i++) {
            if (c[i] > 1 && !zeroG.connected(cur, cur, cur + c[i])) {// of the same type            
                correct = false;
                break;
            }
            
            cur += c[i];
        }
        
        if (correct) {        
            int[][] d = G.shortestPath();
            
            out.println("Yes");
            printArray(d, out);
        }
        else {
            out.println("No");
        }
            
        out.flush();
    }        
    
    private static int[] calcType(int N, int[] c) {
        int[] type = new int[N];
        int nt = 0;
        int i = 0;
        for (int j = 0; j < N; j++)
            if (nt < c[i]) {
                type[j] = i;
                nt++;
            }
            else {
                type[j] = ++i;
                nt = 1;
            }        
        
        return type;
    }
    
    private static void printArray(int[][] a, PrintWriter out) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                out.print(a[i][j] + " ");
            out.println();
        }
    }
}
