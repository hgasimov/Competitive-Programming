package topcoder;


/**
 * SRM 604 (DIV 2)
 */
public class FoxAndWord {
    public static int howManyPairs(String[] words) {
        int N = words.length;
        int sum = 0;
        for (int i = 0; i < N-1; i++)
            for (int j = i+1; j < N; j++) 
                if (interesting(words[i], words[j])) sum++;
            
        
        return sum;
    }
    
    private static boolean interesting(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        
        int N = s1.length();
        for (int i = 1; i < N; i++) {
            String A = s1.substring(0, i);
            String B = s1.substring(i);
            if (B.concat(A).equals(s2)) return true;
        }
        
        return false;
    }
    
}
