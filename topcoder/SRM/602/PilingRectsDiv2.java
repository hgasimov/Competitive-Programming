package topcoder;

/**
 * SRM 602 (DIV 2)
 * @author huseyngasimov
 */
public class PilingRectsDiv2 {
    public static int getmax(int[] X, int[] Y, int limit) {
        int N = X.length;
        for (int i = 0; i < N; i++) 
            if (X[i] > Y[i]) {
                int tmp = X[i];
                X[i] = Y[i];
                Y[i] = tmp;
            }
        
        int[][] area = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++) {
                area[j][i] = area[i][j] = inters_area(X[i], Y[i], X[j], Y[j]);                
            }
        
        boolean[] removed = new boolean[N];
        while(!OK(area, N, limit, removed) ) {
            int min_i = calcMin(area, N, removed, limit);
            
            removed[min_i] = true;
        }
        
        int res = calcRes(removed);
        return (res > 0) ? res : -1;
    }
    
    private static int inters_area(int x1, int y1, int x2, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        return x*y;
    }
    
    private static boolean OK(int[][] area, int N, int limit, boolean[] removed) {
        for (int i = 0; i < N; i ++)
            if (!removed[i])
                for (int j = 0; j < N; j++)
                    if (!removed[j])
                        if (area[i][j] < limit) return false;
        
        return true;
    }
    
    private static int calcRes(boolean[] removed) {
        int sum = 0;
        for (boolean rem: removed) 
            if (!rem) sum++;
        
        return sum;
    }
    
    private static int calcMin(int[][] area, int N, boolean[] removed, int limit) {
        int min_i = -1; 
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++)
            if (!removed[i]) {
                int total = 0;
                boolean found = false;
                for (int j = 0; j < N; j++)
                    if (!removed[j]) {
                        found = true;
                        if(area[i][j] >= limit) total++;                        
                    }
                
                if (found && total < min) {
                    min = total;
                    min_i = i;
                }
            }
        
        return min_i;
    }
    
    public static void main(String[] args) {
        int[] X = {1,2,3,1};
        int[] Y = {3,2,4,4};
        int limit = 3;
        
        println(getmax(X, Y, limit));
    }
    
    private static void println(Object o) { System.out.println(o);}
}
