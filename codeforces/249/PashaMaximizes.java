package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #249 (Div. 2), Problem B
 */
public class PashaMaximizes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        char[] a = in.next().toCharArray();
        int k = in.nextInt();
        int N = a.length;
                
        for (int i = 0; i < N && k > 0; i++) {
            int maxi = i;
            for (int j = i + 1; j < N && j <= i + k; j++)
                if (a[j] > a[maxi])
                    maxi = j;
            
            if (maxi == i) continue;
            for (int j = maxi; j > i; j--) {
                char tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
            }
            k -= maxi - i;
        }

        out.println(String.valueOf(a));
        out.flush();
    }
}
