package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 *  Codeforces Round #242 (Div. 2), Problem A
 */
public class Squats {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        
        int up = 0;
        for (char c : s)
            if (c == 'X') up++;
        
        int down = n - up;
        
        int sec = 0;
        if (up > down) {
            for (int i = 0; i < n && up > down; i++)
                if (s[i] == 'X') {
                    s[i] = 'x';
                    up--; down++;
                    sec++;
                }
        }
        else if (down > up) {
            for (int i = 0; i < n && up < down; i++)
                if (s[i] == 'x') {
                    s[i] = 'X';
                    up++; down--;
                    sec++;
                }
        }
        
        out.println(sec);
        out.println(String.valueOf(s));
        out.flush();
    }
}
