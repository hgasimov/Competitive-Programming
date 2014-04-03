package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #232 (Div. 2), Problem B
 */
public class OnCorruptionandNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long ni = in.nextInt(),
                 li = in.nextInt(),
                 ri = in.nextInt();
            
            long cnt = ni / li;
            out.println(cnt * ri < ni ? "No" : "Yes");
        }
        
        out.flush();
    }
}
