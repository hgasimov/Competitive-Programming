package topcoder;

/**
 * SRM 602 (DIV 2)
 * @author huseyngasimov
 */
public class TypoCoderDiv2 {    
    public static int count(int[] rating) {
        int res = 0;
        int prev = 500;
        for (int i = 0; i < rating.length; i++) {
            if (prev < 1200) {
                if (rating[i] >= 1200) res++;
            }
            else if (rating[i] < 1200) res++;
            
            prev = rating[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] rating = {1200};
        println(count(rating));
    }
    
    private static void println(Object o) { System.out.println(o);}
}
