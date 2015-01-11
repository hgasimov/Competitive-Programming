package FacebookHackerCup.hc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LaserMaze {
    private static String curdir = "io//fb//qualification//LaserMaze//";
    
    private static Scanner in;
    private static PrintWriter out;
    private static int[][][] f_score;

    private static class Node implements Comparable<Node> {
        private int i, j, gscore;       
        
        Node(int i, int j, int gscore) {
            this.i = i;
            this.j = j;
            this.gscore = gscore;            
        }
        
        @Override
        public int compareTo(Node o) {
            int this_fscore = f_score[gscore % 4][i][j];
            int o_fscore = f_score[o.gscore % 4][o.i][o.j];
            return Integer.compare(this_fscore, o_fscore);
        }
    }
    
    private static class PrioritySet {
        private PriorityQueue<Node> pq = new PriorityQueue<>();
        private boolean[][][] set;
        private int M, N;
        
        PrioritySet(int M, int N) {
            this.M = M;
            this.N = N;
            set = new boolean[4][M][N];
        }
        
        public void push(Node n) {            
            if (!set[n.gscore%4][n.i][n.j]) {
                pq.add(n);
                set[n.gscore%4][n.i][n.j] = true;
            }
        } 
        
        public Node poll() {
            if (pq.isEmpty()) return null;
            
            Node n = pq.poll();
            set[n.gscore%4][n.i][n.j] = false;
            return n;
        }
        
        public boolean contains(Node n) {
            return set[n.gscore%4][n.i][n.j];
        }
        
        public boolean isEmpty() {
            return pq.isEmpty();
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File(curdir + "laser_maze_example_input.txt"));
        out = new PrintWriter(curdir + "laser_maze_example_output.txt");

        int T = in.nextInt();        
        for (int caseno = 1; caseno <= T; caseno++) {
            int M = in.nextInt();
            int N = in.nextInt();
            char[][] a = readArray(in, M, N);            
            
            String answer = solve(M, N, a);
            printf("Case %d#: %s\n", caseno, answer);
        }

        out.flush();
    }
    
    /*
     * Applies modified version of A* algorithm
     */
    private static String solve(int M, int N, char[][] a) {
        int[] S = find(a, M, N, 'S');
        int[] G = find(a, M, N, 'G');
        a[S[0]][S[1]] = a[G[0]][G[1]] = '.';
        
        char[][][] maze = new char[4][M][N];
        
        createMaze(maze, a, M, N, 0); // maze of phase 0
        createMaze(maze, a, M, N, 1); // maze of phase 1
        createMaze(maze, a, M, N, 2); // maze of phase 2
        createMaze(maze, a, M, N, 3); // maze of phase 3
        
        boolean[][][] closedset = new boolean[4][M][N]; // closed set in 4 phases
        int[][][] g_score = new int[4][M][N]; // g_score in 4 phases
        f_score = new int[4][M][N]; // f_score in 4 phases
        
        g_score[0][S[0]][S[1]] = 0;
        f_score[0][S[0]][S[1]] = g_score[0][S[0]][S[1]] + heuristics_score(S[0], S[1], G[0], G[1]);
        
        PrioritySet openset = new PrioritySet(M, N);
        openset.push(new Node(S[0], S[1], 0));
        
        while (!openset.isEmpty()) {
            Node current = openset.poll();
            if (current.i == G[0] && current.j == G[1]) return String.valueOf(current.gscore);
            
            int phase = current.gscore % 4;
            closedset[phase][current.i][current.j] = true; // add current to closedset
            
            phase = (phase + 1) % 4;
            for (Node nb : neighbors(current.i, current.j, maze[phase], M, N)) {
                if (closedset[phase][nb.i][nb.j]) continue; // if neighbor in closedset
                
                nb.gscore = current.gscore + 1;
                if (!openset.contains(nb) || nb.gscore < g_score[nb.gscore % 4][nb.i][nb.j]) {
                    g_score[nb.gscore % 4][nb.i][nb.j] = nb.gscore;
                    f_score[nb.gscore % 4][nb.i][nb.j] = g_score[nb.gscore % 4][nb.i][nb.j] + heuristics_score(nb.i, nb.j, G[0], G[1]);
                    if (!openset.contains(nb))
                        openset.push(nb);
                }
            }
        }
        
        return "impossible";
    }
    
    private static List<Node> neighbors(int i, int j, char[][] a, int M, int N) {
        List<Node> list = new ArrayList<>();
        
        if (i - 1 >= 0 && a[i-1][j] == '.') list.add(new Node(i-1, j, 0));
        if (i + 1 < M && a[i+1][j] == '.') list.add(new Node(i+1, j, 0));
        if (j - 1 >= 0 && a[i][j-1] == '.') list.add(new Node(i, j-1, 0));
        if (j + 1 < N && a[i][j+1] == '.') list.add(new Node(i, j+1, 0));
        
        return list;
    }
    
    private static int heuristics_score(int i0, int j0, int i1, int j1) {
        return Math.abs(i1 - i0) + Math.abs(j1 - j0);
    }

    private static char[][] readArray(Scanner in, int M, int N) {
        char[][] a = new char[M][N];
        for (int i = 0; i < M; i++) {
            String s = in.next();
            for (int j = 0; j < N; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        return a;
    }        
    
    private static char[][] createMaze(char[][][] maze, char[][] a, int M, int N, int phase) {
        copyMaze(a, maze[phase], M, N);
        char[][] b = maze[phase];        
        
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)  {                
                char c = rotateLazer(a[i][j], phase);
                switch(c) {
                    case '>': 
                        b[i][j] = '#';
                        for (int m = j + 1; m < N; m++)
                            if (a[i][m] == '.') b[i][m] = '#'; else break;
                        break;
                    case 'v': 
                        b[i][j] = '#';
                        for (int m = i + 1; m < M; m++)
                            if (a[m][j] == '.') b[m][j] = '#'; else break;
                        break;
                    case '<': 
                        b[i][j] = '#';
                        for (int m = j - 1; m >= 0; m--)
                            if (a[i][m] == '.') b[i][m] = '#'; else break;
                        break;
                    case '^': 
                        b[i][j] = '#';
                        for (int m = i - 1; m >= 0; m--)
                            if (a[m][j] == '.') b[m][j] = '#'; else break;
                        break;
                }
            }
        return b;
    }
    
    private static char[][] copyMaze(char[][] a, char[][] b, int M, int N) {
        for (int i = 0; i < M; i++)
            System.arraycopy(a[i], 0, b[i], 0, N);
        return b;
    }
    
    private static char rotateLazer(char laz, int nRotations) {
        nRotations %= 4;
        if (nRotations == 0) {
            if (laz == '>' || laz == 'v' || laz == '<' || laz == '^') return laz;
            return 'x';
        }
        else if (nRotations == 1) {
            if (laz == '>') return 'v';
            if (laz == 'v') return '<';
            if (laz == '<') return '^';
            if (laz == '^') return '>';
            return 'x';
        }
        else {
            char laz_rot1 = rotateLazer(laz, 1);
            return rotateLazer(laz_rot1, nRotations - 1);
        }
    }
    
    private static void printf(String format, Object... args) {
        out.format(format, args);
        System.out.format(format, args);
    }
    
    private static int[] find(char[][] a, int M, int N, char c) {
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == c) 
                    return new int[]{i, j};
        return null;
    }
}
