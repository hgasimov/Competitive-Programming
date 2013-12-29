package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Codeforces Round #222 (Div. 2)
 * @author huseyngasimov
 */
public class Maze {
    private static class Point {
        int x, y;
        Point(int x1, int y1) {
            x = x1; 
            y = y1;
        }
    }
    
    private int n, m;
    private char[][] maze; 
    private boolean[][] marked; 
    private int k, total = 0;
    
    public Maze(char[][] maze, int n, int m, int k) {
        this.maze = maze;
        this.n = n;
        this.m = m;
        this.k = k;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++)
            maze[i] = in.next().toCharArray();
        
        printMaze((new Maze(maze, n, m, k)).solve(), out);
        
        out.flush();

    }
    
    private char[][] solve() {
        marked = new boolean[n][m];
        Point cur = init();    
        if (cur == null) return maze;
        
        DFS(cur.x, cur.y);
        return maze;
    }
    
    private void DFS(int x, int y) {
        if (total >= k) return;
        marked[x][y] = true;
        
        if (y < m-1 && maze[x][y+1] == '.' && !marked[x][y+1]) DFS(x, y+1); // go right
        if (y > 0 && maze[x][y-1] == '.' && !marked[x][y-1]) DFS(x, y-1); // go left
        if (x < n-1 && maze[x+1][y] == '.' && !marked[x+1][y]) DFS(x+1, y); // go up
        if (x > 0 && maze[x-1][y] == '.' && !marked[x-1][y]) DFS(x-1, y); // go down
        
        if (total < k) {
            maze[x][y] = 'X';
            total++;
        }
    }
    
    private Point init() {
        for (int i = 0; i < n; i++)            
          for (int j = 0; j < m; j++)                
            if (maze[i][j] == '.') 
              return new Point(i, j);
        
        return null;
    }    
    
    private static void printMaze(char[][] a, PrintWriter out) { 
        for (char[] line: a) {
            for (char c: line) out.print(c); 
            out.println();
        }
    }
}
