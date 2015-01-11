package FacebookHackerCup.hc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NewYearsResolution {
    private static String curdir = "io//fb//qualification//NewYearsResolution//";
    private static Scanner in;
    private static PrintWriter out;
    
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File(curdir + "new_years_resolution.txt"));
        out = new PrintWriter(curdir + "problemB.answer.txt");

        int T = in.nextInt();
        int N = 0;
        for (int caseno = 1; caseno <= T; caseno++){
            String answer = solve(in.nextInt(), 
                                  in.nextInt(), 
                                  in.nextInt(),
                                  N = in.nextInt(),
                                  readArray(in, N));
            printf("Case %d#: %s\n", caseno, answer);
        }

        out.flush();
    }

    private static String solve(int Gp, int Gc, int Gf, int N, int[][] foods) {
        int itr = (int) Math.pow(2, N); // number of iterations required
        for (int mask = 0; mask < itr; mask++) {
            int GpSum = 0, GcSum = 0, GfSum = 0;
            
            for (int i = 0; i < N; i++) 
                if ((mask & (1 << i)) > 0) { // if the i-th bit of the mask is set
                    GpSum += foods[i][0];
                    GcSum += foods[i][1];
                    GfSum += foods[i][2];
                    
                    if (GpSum > Gp || GcSum > Gc || GfSum > Gf) break;
                }
            
            if (GpSum == Gp && GcSum == Gc && GfSum == Gf) return "yes";
        }
        
        return "no";
    }
    
    private static int[][] readArray(Scanner in, int n) {
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
            a[i][2] = in.nextInt();
        }
        return a;
    }
    
    private static void printf(String format, Object... args) {
        out.format(format, args);
        System.out.format(format, args);
    }
}
