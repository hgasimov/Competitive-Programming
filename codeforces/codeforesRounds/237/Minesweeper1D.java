package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #237 (Div. 2), Problem D
 */
public class Minesweeper1D {
    private static int m = 1000000007;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        out.println(solve(in.next().toCharArray()));       
        out.flush();
    }
    
    private static long solve(char[] s) {
        int n = s.length;        
        for (int i = 0; i < n; i++) 
            switch(s[i]) {
                case '0':
                    if (i > 0) {
                        if (s[i-1] == '?') s[i-1] = 'x';
                        else if (s[i-1] == '*') return 0;
                    }
                    if (i < n-1) {
                        if (s[i+1] == '?') s[i+1] = 'x';
                        else if (s[i+1] == '*') return 0;
                    }
                    break;
                case '1':
                    if (i == 0 || (s[i-1] != '*' && s[i-1] != '?')) {
                        if (i == n-1) return 0;
                        if (s[i+1] == '?') s[i+1] = '*';
                        else if (s[i+1] != '*') return 0;
                    }
                    else if (i == n-1 || (s[i+1] != '*' && s[i+1] != '?')) {
                        if (i == 0) return 0;
                        if (s[i-1] == '?') s[i-1] = '*';
                        else if (s[i-1] != '*') return 0;
                    }
                    else if (s[i-1] == '*') {
                         if (s[i+1] == '*') return 0;
                         if (s[i+1] == '?') s[i+1] = 'x';
                    }
                    else if (s[i+1] == '*') {
                        if (s[i-1] == '*') return 0;
                        if (s[i-1] == '?') s[i-1] = 'x';
                    }
                    else if (s[i-1] == '?' && s[i+1] == '?') s[i-1] = 'x';
                    break;
                case '2':
                    if (i == 0 || i == n-1) return 0;
                    
                    if (s[i-1] == '?') s[i-1] = '*';
                    else if (s[i-1] != '*') return 0;
                    
                    if (s[i+1] == '?') s[i+1] = '*'; 
                    else if (s[i+1] != '*') return 0;
            }
        
        long prod = 1;
        for (int i = 0; i < n; i++)
            if (s[i] == '?')
                prod = (prod * 2) % m;
            
        return prod;        
    }
}
