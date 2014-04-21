package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Good Bye 2013 (the last codeforces contest of 2013)
 * @author huseyngasimov
 */
public class NewYearPresent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        
        int[] a = new int[n];                 
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (a[i] > 0) {
                if (i < n-1) {
                    int cur_i = i;
                    while(a[i] > 0){
                        if (a[cur_i] > 0) {
                            sb.append('P');
                            a[cur_i]--;
                        }
                        
                        if (i == cur_i) {
                            cur_i = i+1;
                            sb.append('R');
                        }
                        else {
                            cur_i = i;
                            sb.append('L');
                        }                                
                    }
                }
                else {
                    int cur_i = i;
                    while(a[i] > 0){
                        if (a[cur_i] > 0) {
                            sb.append('P');
                            a[cur_i]--;
                            if (a[i] <= 0) break;
                        }                        
                        
                        if (i == cur_i) {
                            cur_i = i-1;
                            sb.append('L');
                        }
                        else {
                            cur_i = i;
                            sb.append('R');
                        }                                
                    }
                }
            }
            else if (i < n-1) sb.append('R');
            
        
        out.println(sb.toString());
        out.flush();
    }    
}
