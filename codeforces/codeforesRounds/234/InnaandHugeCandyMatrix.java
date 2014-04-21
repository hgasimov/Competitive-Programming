package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #234 (Div. 2), Problem C
 */
public class InnaandHugeCandyMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
            m = in.nextInt(), 
            x = in.nextInt() % 4,
            y = in.nextInt() % 2,
            z = in.nextInt() % 4,
            p = in.nextInt();                        
        
        for (int i = 0; i < p; i++) {
            Integer row = in.nextInt();
            Integer col = -in.nextInt();
            
            int nrow = n, ncol = m;        
        
            for (int j = 0; j < x; j++) {
                row = rotateClockwise(row, nrow);
                col = rotateClockwise(col, nrow);

                int tmp = nrow;
                nrow = ncol;
                ncol = tmp;
            }
            
            if (y > 0) {      
                row = rotateHorizontally(row, ncol);
                col = rotateHorizontally(col, ncol);
            }
            
            for (int j = 0; j < z; j++) {
                row = rotateCounterClockwise(row, ncol);
                col = rotateCounterClockwise(col, ncol);

                int tmp = nrow;
                nrow = ncol;
                ncol = tmp;
            }
            
            if (row > col) {
                out.println(row + " " + (-col));
            }
            else {
                out.println(col + " " + (-row));
            }
        }                
        
        out.flush();
    }                       
    
    private static int rotateClockwise(int a, int nrow) {
        // first row becomes last column
        // first column becomes first row
        return a > 0 ? -(nrow - a + 1) : -a;        
    }        
    
    private static int rotateCounterClockwise(int a, Integer ncol) {
        // first row becomes first column 
        // first column becomes last row
        return a > 0 ? -a : ncol + a + 1;        
    }
       
    
    private static int rotateHorizontally(int a, int ncol) {        
        if (a < 0) // if it is a column
            a = -(ncol + a + 1);
        return a;
    }
}
