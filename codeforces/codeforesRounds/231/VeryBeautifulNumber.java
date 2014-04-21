package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #231 (Div. 2), Problem B
 */
public class VeryBeautifulNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);        
        
        int p = in.nextInt();
        int x = in.nextInt();
        int[] a = new int[1000003];
        
        for (int i = 1; i < 10; i++)  {  
            a[1] = i;  
            int mod = 0;  
            for (int j = 2; j <= p; j++) {  
                int t = a[j-1] * x + mod;  
                a[j] = t % 10;
                mod = t / 10;
            }
            
            if(a[p] != 0
                    && (a[p] * x) % 10 + mod == i 
                    && (a[p] * x) / 10 == 0) {  
            
                for (int j = p; j > 0; j--)  
                    out.print(a[j]); 
                out.flush();
                return;
            }  
        }  
        
        out.println("Impossible");
        out.flush();
    }    
}
