/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

/**
 *
 * @author huseyngasimov
 */
public class LittleElephantAndRGB {
    
    public static long getNumber(String[] list, int minGreen) {
        StringBuilder sb = new StringBuilder();
        for (String s1: list) sb.append(s1);
        String s = sb.toString();
        
        println(s);
        
        int numb = 0; int N = s.length();
        for (int a = 0; a < N - 1; a++) 
            for (int b = a; b < N; b++)
                for (int c = b+1; c < N; c++)
                    for (int d = c; d < N; d++) {
                        if (b - a + 1 + d - c + 1 < minGreen) continue;
                        //println("Checking: [" + a + ".." + b + "] [" + c + ".." + d + "]");
                        String T = s.substring(a, b+1) + s.substring(c, d+1);
                        if (isNice(T, minGreen)) numb++;
                    }
                        
            
        return numb;
    }
    
    private static boolean isNice(String s, int minGreen) {
        if (s == null || s.length() < minGreen) return false;
        int greenStart = -1;
        for (int i = 0; i < s.length(); i++)  
            if (s.charAt(i) == 'G') {
                if (greenStart == -1) greenStart = i;
                if (i - greenStart + 1 >= minGreen) return true;
            }
            else greenStart = -1;
        
        return false;
    }
    
    public static void main(String[] args) {
        String[] list = {"GRGGGRBRGG", "GGGGGGGG", "BRGRBRB"};
        int minGreen = 4;
        println(getNumber(list, minGreen));
    }
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
