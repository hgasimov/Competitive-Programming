package codeforces;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Codeforces Round #249 (Div. 2), Problem C
 */
public class Cardiogram {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = readArray(in, n);
        
        int[][] points = new int[n+1][2];
        int sign = 1;
        for (int i = 0; i < n; i++) {
            points[i+1][0] = points[i][0] + a[i];
            points[i+1][1] = points[i][1] + sign * a[i];
            sign *= -1;
        }

        int miny = points[0][1];
        for (int i = 1; i <= n; i++)
            miny = Math.min(miny, points[i][1]);
                
        for (int i = 0; i <= n; i++)
            points[i][1] -= miny;
        
        int sum = sum(a);
        int[][] slashes = new int[sum][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= points[i][0] - points[i-1][0]; j++) {
                int x = points[i-1][0] + j, y;
                if (points[i][1] > points[i-1][1]) {
                    y = points[i-1][1] + j;
                    slashes[x-1][2] = 1;   
                }
                else {
                    y = points[i-1][1] - j + 1;
                    slashes[x-1][2] = 0;
                }
                slashes[x-1][0] = x;
                slashes[x-1][1] = y;   
            }
        }        
            
        Arrays.sort(slashes, new Comparator<int[]> () {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                else {
                    return -Integer.compare(o1[1], o2[1]);
                }
            }            
        });     
            
        int i = 0;
        for (int y = slashes[0][1]; y >= 0; y --) {
            for (int x = 1; x <= sum; x++) {
                if (slashes[i][1] == y && slashes[i][0] == x) {
                    out.print(slashes[i][2] == 0 ? '\\' : '/');
                    if (i+1 < slashes.length) i++;
                }
                else {
                    out.print(' ');
                }
            }
            out.print('\n');
        }
                
        out.flush();
    }
    
    private static int sum(int[] a) {
        int sum = 0;
        for (int i : a) sum += i;
        return sum;
    }

    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
}
