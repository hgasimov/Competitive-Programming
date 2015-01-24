package FacebookHackerCup.hc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Homework {
    private static String curdir = "io//fb//round1//Homework//";
    private static Scanner in;
    private static PrintWriter out;
    private static int max = 10000000;
    private static int maxPrimacity = 8;
    
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File(curdir + "homework.txt"));
        out = new PrintWriter(curdir + "problemA_output.txt");

        int T = in.nextInt();      
        int[] p = primacity(max+1);
                
        for (int caseno = 1; caseno <= T; caseno++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int K = in.nextInt();
            if (K > maxPrimacity) {
                printf("Case %d#: %d\n", caseno, 0);
                continue;
            }
            
            int cnt = 0;
            for (int j = A; j <= B; j++)
                if (p[j] == K) cnt++;
            
            printf("Case %d#: %d\n", caseno, cnt);
        }

        out.flush();
    }
    
    private static int[] primacity(int N) {
        int[] p = new int[N];
        int[] a = new int[N];
        for (int i = 1; i < N; i++)
            a[i] = i;
        
        for (int i = 2; i < N; i++) {
            if (a[i] == 1) continue;
            for (int j = i; j < N; j+= i) {
                while (a[j] % i == 0) a[j] /= i;
                p[j] += 1;
            }
        }
        
        return p;
    }
    
    private static void printf(String format, Object... args) {
        out.format(format, args);
        System.out.format(format, args);
    }
}
