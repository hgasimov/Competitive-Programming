package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #231 (Div. 2), Problem C
 */
public class Dominoes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            m = in.nextInt();
        
        int n11 = 0, n10 = 0, n01 = 0;
        
        for (int i = 0 ; i < n; i++)
            for (int j = 0; j < m; j++) 
                switch(in.next()) {
                    case "11": n11++; break;
                    case "10": n10++; break;
                    case "01": n10++; break;              
                }
        
        boolean evenRow = true;
        for (int i = 0 ; i < n; i++) {            
            for (int j = 0; j < m; j++) 
                if ((evenRow && n10 > 0) ||(!evenRow && n01 > 0)) {
                    if (evenRow) {
                        out.print("10 ");
                        n10--;
                        if (n10 > 0) {
                            n10--; n01++;
                        }
                    }
                    else {                        
                        out.print("01 ");
                        n01--;
                    }                    
                }
                else if (n11 > 0) {
                    out.print("11 ");
                    n11--;
                }
                else {
                    out.print("00 ");
                }
            
            out.println();
            evenRow = !evenRow;
        }
        
        out.flush();
    }
}
