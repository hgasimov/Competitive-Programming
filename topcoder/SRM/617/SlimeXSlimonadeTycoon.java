package topcoder;

/*
 * SRM 617 (div 2), 600 point problem
 */
public class SlimeXSlimonadeTycoon {
    public static int sell(int[] morning, int[] customers, int stale_limit) {
        int sum = 0;
        int N = morning.length;
        
        int[] limonades = new int[N];
        for (int i = 0; i < N; i++) {
            limonades[i] = morning[i];
            for (int j = Math.max(0, i - stale_limit + 1); j <= i && customers[i] > 0; j++) {
                int sold = Math.min(customers[i], limonades[j]);
                customers[i] -= sold;
                limonades[j] -= sold;
                sum += sold;
            }
        }
        
        return sum;
    }
}
