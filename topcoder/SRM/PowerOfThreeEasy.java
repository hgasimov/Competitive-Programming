package topcoder;


/**
 * SRM 604 (DIV 2)
 */
public class PowerOfThreeEasy {
    public static String ableToGet(int x, int y) {    
        return ableGet(0, 0, 0, x, y) ? "Possible" : "Impossible";
    }
    
    private static boolean ableGet(int k, long sumx, long sumy, int x, int y) {
        if (sumx == x && sumy == y) return true;
        if (sumx > x || sumy > y) return false;
        
        long incr = (long) Math.pow(3, k);
        if (ableGet(k+1, sumx + incr, sumy, x, y)) return true;
        if (ableGet(k+1, sumx, sumy + incr, x, y)) return true;
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(ableToGet(1000000000, 1000000000));
    }
}
