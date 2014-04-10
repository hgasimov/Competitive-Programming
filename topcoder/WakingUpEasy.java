package topcoder;

/*
 * SRM 616, 250 point problem
 */
public class WakingUpEasy {
    public static int countAlarms(int[] volume, int S) {
        int cur = 0;
        int n = 0;
        while (S > 0) {
            S -= volume[cur];
            cur = (cur + 1) % volume.length;
            n++;
        }
        
        return n;
    }
    
    public static void main(String[] args) {
        int[] volume = {1};
        int S = 1;
        System.out.println(countAlarms(volume, S));
    }
}