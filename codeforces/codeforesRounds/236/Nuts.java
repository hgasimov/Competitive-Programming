package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 *  Codeforces Round #236 (Div. 2), Problem A
 */
public class Nuts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int maxSec = in.nextInt(),
            nuts = in.nextInt(),
            divs = in.nextInt(),
            secNuts = in.nextInt();
        
        int boxes = 0;
        while (nuts > 0) {
            if (divs >= maxSec - 1) {
                nuts -= maxSec * secNuts;
                divs -= maxSec - 1;
            }
            else {
                nuts -= (divs + 1) * secNuts;
                divs = 0;
            }
            
            boxes++;
        }
        
        out.println(boxes);
        out.flush();
    }
}
