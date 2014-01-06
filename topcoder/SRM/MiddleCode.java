package topcoder;

import java.util.ArrayList;

/**
 * SRM 603 (DIV 2) 
 */
public class MiddleCode {
    public static String encode(String s) {        
        ArrayList<Character> list = new ArrayList<Character>();
        for (char c: s.toCharArray()) list.add(c);
        
        int N = s.length();
        char[] ts = new char[N];
        for (int i = 0; i < N; i++) {
            if (list.size() % 2 == 1) {
                int mid = list.size() / 2;
                ts[i] = list.get(mid);
                list.remove(mid);                
            }
            else {
                int mid_right = list.size() / 2;
                int mid_left = mid_right - 1;
                int mid_add = list.get(mid_right) < list.get(mid_left) ? mid_right : mid_left;
                ts[i] = list.get(mid_add);
                list.remove(mid_add);  
            }
        }
        
        
        return String.copyValueOf(ts);
    }
    
    public static void main(String[] args) {
        String s = "a";
        println(encode(s));
    } 
    
    private static void println(Object o) { System.out.println(o);}
}