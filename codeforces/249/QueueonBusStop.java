package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #249 (Div. 2), Problem A
 */
public class QueueonBusStop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(),
            m = in.nextInt();
        
        int sum = 0;
        int[] a = readArray(in, n);
        int cnt = 0;        
        int places = 0;
        for (int i = 0; i < n; ) {            
            if (places < a[i]) {
                cnt++;
                places = m;
            }
            else {
                places -= a[i++];                
            }
        }

        out.println(cnt);
        out.flush();
    }

    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
}
