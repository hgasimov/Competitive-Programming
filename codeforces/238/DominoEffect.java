package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #238 (Div. 2), Problem B
 */
public class DominoEffect {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        int sum = 0;
        int i = 0, j = -1;
        for (; i < n; i++)
            if (s[i] == 'R' || s[i] == 'L') {
                if (s[i] == 'R') {
                    sum += i;   
                    j = i-1;
                }
                else j = i;
                break;
            }        
        
        while (j < n) {
            for (i = j+1; i < n && s[i] != 'R'; i++);
            sum += i - j - 1;
            
            for (j = i+1; j < n && s[j] != 'L'; j++);
            if (j < n && ((j - i) % 2 == 0)) sum++;
        }
        
        out.println(sum);
        out.flush();
    }
}
