package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/** 
 * Codeforces Round #224 (Div. 2) 
 */
public class KseniaPanScales {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        String scales = in.next();
        String remain = in.next();
        
        if ((scales.length() + remain.length()) % 2 == 0) {
            out.println("Impossible"); //println("dbg 1");
        }
        else {
            int N = scales.length();
            int left = scales.indexOf("|");
            int right = N - left - 1;
            int diff = Math.abs(left - right); //println("diff = " + diff);
            if (diff > remain.length()) {
                out.println("Impossible"); //println("dbg 2");
            }
            else {            
                String sleft = "", sright = "";
                if (left < right) {
                    sleft = remain.substring(0, diff);
                }
                else if (right < left) {
                    sright = remain.substring(0, diff);
                }
                
                int dif_remain = remain.length() - diff; //println("dif_remain = " + dif_remain);
                if (dif_remain % 2 == 0) {
                    if (dif_remain > 0) {
                        int each = dif_remain / 2; //println("each = " + each);
                        sleft += remain.substring(diff, diff + each); //println("sleft = " + sleft);
                        sright += remain.substring(diff + each, remain.length());  //println("sright = " + sright);               
                    }
                    
                    out.println(sleft + scales + sright);
                }
                else {
                    out.println("Impossible");
                }
            }
        }
        
        out.flush();
    }
    
    //private static void println(Object o) { System.out.println(o);}
    
    //ABC|D
    //EFGHIJKL
}
