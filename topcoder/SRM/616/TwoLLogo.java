package topcoder;

/*
 * SRM 616, 1000 point problem
 */
public class TwoLLogo {
    private static long total = 0;
    private static char[][] cgrid;
    private static int N, M;
    private static boolean[][] used;    

    public static long countWays(String[] grid) {
        long start = System.currentTimeMillis();
        
        N = grid.length;
        M = grid[0].length();
        used = new boolean[N][M];
        cgrid = new char[N][M];
        for (int i = 0; i < N; i++)
            System.arraycopy(grid[i].toCharArray(), 0, cgrid[i], 0, M);                
        
        recur(0);
        
        System.out.println(System.currentTimeMillis() - start);
        
        return total;
    }
    
    private static void recur(int level) {
        for (int i = 1; i < N; i++)
            for (int j = 0; j < M-1; j++)
                if ((!used[i][j]) 
                        && cgrid[i][j] == '.' 
                        && cgrid[i-1][j] == '.' 
                        && cgrid[i][j+1] == '.')
                    lookAt(i, j, level);                    
    }
    
    private static void lookAt(int i, int j, int level) {
        if (level == 0) used[i][j] = true;
        cgrid[i][j] = '#';

        int end_i = findend_i(i, j);        
        int end_j = findend_j(i, j);
        
        if (level == 1) {
            total += (i - end_i) * (end_j - j);
        }
        else if (i - end_i > 0 && end_j - j > 0) {
            for (int k = i-1; k >= end_i; k--) cgrid[k][j] = '#';
            
            for (int ki = end_i; ki < i; ki++) {
                for (int k = j+1; k <= end_j; k++) cgrid[i][k] = '#';

                for (int kj = end_j; kj > j; kj--) {
                    recur(level+1);
                    cgrid[i][kj] = '.';
                }
                
                cgrid[ki][j] = '.';
            }
        }

        cgrid[i][j] = '.';
    }
    
    public static void main(String[] args) {
        //String[] grid = {"....", "...."};
        String[] grid ={"..............................", 
                        "......................#.......", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        ".......#......................", 
                        ".........#....................", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        "............#.................", 
                        "..............................", 
                        "............#.................", 
                        "..............................", 
                        "...............#..............", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        "...#..........................", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        "..............................", 
                        ".....#........................", 
                        "..............................", 
                        ".............................."};
        
        System.out.println(countWays(grid));
    }

    private static int findend_i(int i, int j) {
        for (int k = i-1; k >= 0; k--) {
            if (cgrid[k][j] == '#') return k+1;
        }
        return 0;
    }

    private static int findend_j(int i, int j) {
        for (int k = j+1; k < M; k++) {
            if (cgrid[i][k] == '#') return k-1;
        }
        return M-1;
    }
}
