package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Good Bye 2013 (the last codeforces contest of 2013)
 * @author huseyngasimov
 */
public class NewYearCandles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int a = in.nextInt();
        int b = in.nextInt();
                        
        int hours = a;
        int burnedCandles = a;
        while (burnedCandles >= b) {
            int newcandles = burnedCandles / b;            
            burnedCandles -= newcandles*b; // remained
            burnedCandles += newcandles; // burn again
            hours += newcandles;
        }
        
        out.println(hours);
        
        out.flush();
    }
}
