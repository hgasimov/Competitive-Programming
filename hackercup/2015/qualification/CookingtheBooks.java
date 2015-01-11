package FacebookHackerCup.hc2015;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CookingtheBooks {
    private static String curdir;
    private static Scanner in;
    private static PrintWriter out;
    
    public static void main(String[] args) throws IOException {
        curdir = "io//fb//qualification//CookingtheBooks//";
        in = new Scanner(new File(curdir + "cooking_the_books.txt"));
        out = new PrintWriter(curdir + "problemA.answer.txt");

        int T = in.nextInt();
        for (int caseno = 1; caseno <= T; caseno++){
            printf("Case %d#: %s\n", caseno, solve(in.next()));
        }

        out.flush();
    }   
    
    private static String solve(String s) {
        int min = Integer.valueOf(s);
        int max = min;
        
        char[] a = s.toCharArray();
        for (int i1 = 0; i1 < a.length - 1; i1++)
            for (int i2 = i1 + 1; i2 < a.length; i2++) {
                if (i1 == 0 && a[i2] == '0') continue;
                
                int val = swapEval(a, i1, i2);
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        
        return min + " " + max;
    }
    
    private static int swapEval(char[] a, int i1, int i2) {
        swap(a, i1, i2);
        int ret = Integer.valueOf(String.valueOf(a));
        swap(a, i1, i2);
        return ret;
    } 
    
    private static void swap(char[] a, int i1, int i2) {
        char tmp = a[i1];
        a[i1] = a[i2];
        a[i2] = tmp;
    }
    
    private static void printf(String format, Object... args) {
        out.format(format, args);
        System.out.format(format, args);
    }
}
