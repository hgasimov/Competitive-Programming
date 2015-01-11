package codeforces;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #238 (Div. 2), Problem C
 */
public class UnusualProduct {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        byte sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i == j) sum ^= in.nextByte();
                else in.next();
        
        int Q = in.nextInt();
        for (int q = 0; q < Q; q++)
            if (in.nextByte() == 3) {
                out.print(sum);
            }
            else {
                in.nextByte();
                sum ^= 1;  
            }
        
        
        out.flush();
    }
}
