package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #235 (Div. 2), Problem B
 */
public class SerejaandContests {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int x = in.nextInt();
        int k = in.nextInt();
        
        boolean[] id = new boolean[x];
        for (int i = 0; i < k; i++) {
            int rtype = in.nextInt();
            id[in.nextInt()] = true;
            if (rtype == 1) {                
                id[in.nextInt()] = true;                
            }
        }
        
        int min = 0, max = 0;
        for (int i = 1; i < x; i++) 
            if (!id[i]) {
                min++;
                    
                if (i < x-1 && (!id[i+1])) {
                    max += 2;
                    i++;
                }
                else {
                    max++;
                }
                //System.out.println(i + " " + min + " " + max);
            }
            
        out.println(min + " " + max);
        out.flush();
    }
}
