package topcoder;

/*
 * SRM 615 (Div 2), 250 point problem
 */
public class AmebaDiv2 {
    public static int simulate(int[] X, int A) {
        int amb = A;
        for (int i = 0; i < X.length; i++)
            if (amb == X[i]) amb *= 2;
        return amb;
    }
    
    
    public static void main(String[] args) {
        int[] X = {1};
        int A = 1;
        
    }
}
