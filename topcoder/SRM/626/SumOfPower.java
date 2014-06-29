package topcoder;

/*
 * SRM 626 (Div 2), 250 point problem
 */
public class SumOfPower {    
    public static int findSum(int[] array) {
        int n = array.length;
        int[] sum = new int[n];
        sum[0] = array[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i-1] + array[i];
        
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                res += sum[j];
                if (i > 0) res -= sum[i-1];
            }
        
        return res;                
    }
    
    public static void main(String[] args) {
        int[] a = {-1};
        System.out.println(findSum(a));
    }
}
