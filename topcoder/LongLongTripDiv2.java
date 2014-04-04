package topcoder;

/*
 * SRM 615 (Div 2), 500 point problem
 */
public class LongLongTripDiv2 {
    public static String isAble(long D, int T, int B) {
        if (D < T) return "Impossible";
        if (D == T) return "Possible";
        
        if ((D - T) % (B - 1) != 0) return "Impossible";
        if ((D - T) / (B - 1) > T) return "Impossible";
        return "Possible";
    }
    
    
    public static void main(String[] args) {
        System.out.println(isAble(10, 6, 3));
    }
}
