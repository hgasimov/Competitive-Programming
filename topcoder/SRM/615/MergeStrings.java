package topcoder;

/*
 * SRM 615 (Div 2), 1000 point problem
 */
public class MergeStrings {
    private static class Getmin {
        private char[] S, A, B;
        private String res;
        private String[][][] cache;
        
        public Getmin(String S, String A, String B) {
            this.S = S.toCharArray();
            this.A = A.toCharArray();
            this.B = B.toCharArray();
            cache = new String[S.length()][A.length() + 1][B.length() + 1];
            
            res = getmin(0, 0, 0); 
            if (res == null) res = "";
        }
        
        private String saveToCache(int k, int i, int j, String res) {
            cache[k][i][j] = res == null ? "" : res;
            return res;
        }
        
        private String getmin(int k, int i, int j) {
            if (k >= S.length) return "";
            if (cache[k][i][j] != null) {
                return "".equals(cache[k][i][j]) ? null : cache[k][i][j];
            }
            
            if (j >= B.length) {
                if (S[k] != '?' && A[i] != S[k]) return saveToCache(k, i, j, null);
                String s1 = getmin(k+1, i+1, j);
                return saveToCache(k, i, j, s1 == null ? null : A[i] + s1);
            }
            
            if (i >= A.length) {
                if (S[k] != '?' && B[j] != S[k]) return saveToCache(k, i, j, null);
                String s2 = getmin(k+1, i, j+1);
                return saveToCache(k, i, j, s2 == null ? null : B[j] + s2);
            }
            
            if (A[i] == B[j]) {
                String s1 = getmin(k+1, i+1, j);
                String s2 = getmin(k+1, i, j+1);
                if (s1 == null && s2 == null) return saveToCache(k, i, j, null);
                if (s1 == null) return saveToCache(k, i, j, B[j] + s2);
                if (s2 == null) return saveToCache(k, i, j, A[i] + s1);
                return saveToCache(k, i, j, s1.compareTo(s2) < 0 ? A[i] + s1 : B[j] + s2);
            }
            
            if (S[k] == '?') {
                if (A[i] < B[j]) {                     
                    String s1 = getmin(k+1, i+1, j);
                    if (s1 != null) return saveToCache(k, i, j, A[i] + s1);

                    String s2 = getmin(k+1, i, j+1);
                    return saveToCache(k, i, j, s2 == null ? null : B[j] + s2);
                }
                else {
                    String s2 = getmin(k+1, i, j+1);
                    if (s2 != null) return saveToCache(k, i, j, B[j] + s2);
                    
                    String s1 = getmin(k+1, i+1, j);
                    return saveToCache(k, i, j, s1 == null ? null : A[i] + s1);
                }
            }
            else {
                if (A[i] != S[k] && B[j] != S[k]) return saveToCache(k, i, j, null);
                                
                if (A[i] == S[k]) {
                    String s1 = getmin(k+1, i+1, j);
                    return saveToCache(k, i, j, s1 == null ? null : A[i] + s1);
                }

                String s2 = getmin(k+1, i, j+1);
                return saveToCache(k, i, j, s2 == null ? null : B[j] + s2);
            }
        }
        
        public String getRes() { return res; }
    }
    
    public static String getmin(String S, String A, String B) {
        Getmin gm = new Getmin(S, A, B);
        return gm.getRes();
    }
    
    public static void main(String[] args) {
        String s = "???????V?WV?O?W???V?W??";
        String a = "OWOVOOOVOWVWOWWVWWVW";
        String b = "OOW";
        //returns "OWOVOOOVOWVOOWWOWWVWWVW"
        
        System.out.println(getmin(s, a, b));
    }
}
