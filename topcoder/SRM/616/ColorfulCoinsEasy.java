package topcoder;

/*
 * SRM 616, 500 point problem
 */
public class ColorfulCoinsEasy {
    private static boolean[] marked;
    private static int[] multp;
    private static int N;
    public static String isPossible(int[] values) {
        N = values.length;
        if (N == 1) return "Possible";
        
        marked = new boolean[N+1];
        multp = new int[N];
                
        return isPossible(values, 0) ? "Possible" : "Impossible";
    }
    
    private static boolean isPossible(int[] values, int level) {
        if (level == N) {
            for (int i = 0; i < N-1; i++)
                if (values[i] * multp[i] >= values[i+1])
                    return false;
            
            return true;
        }
        
        for (int j = 1; j <= N; j++) {
            if (!marked[j]) {
                marked[j] = true;
                multp[level] = j;
                if (isPossible(values, level+1)) return true;
                marked[j] = false;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] values = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384};
        System.out.println(isPossible(values));
    }
}
