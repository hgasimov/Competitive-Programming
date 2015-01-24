package FacebookHackerCup.hc2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class Autocomplete {
    private static String curdir = "io//fb//round1//Autocomplete//";
    private static Scanner in;
    private static PrintWriter out;
    
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File(curdir + "autocomplete.txt"));
        out = new PrintWriter(curdir + "round1_problemB_output.txt");
                
        int T = in.nextInt();
        for (int caseno = 1; caseno <= T; caseno++) {
            int N = in.nextInt();
            TreeSet<String> set = new TreeSet<>();
            
            int sum = 1;
            set.add(in.next());
            for (int i = 1; i < N; i++) {
                String s = in.next();                
                
                String ceil = set.ceiling(s), 
                       floor = set.floor(s);
                
                int maxPref1 = ceil == null ? 0: maxPrefix(ceil, s, caseno);
                int maxPref2 = floor == null ? 0: maxPrefix(floor, s, caseno);
                sum += Math.max(maxPref1, maxPref2);
                
                set.add(s);
            }
            
            printf("Case %d#: %d\n", caseno, sum);
        }

        out.flush();
    }    
    
    private static int maxPrefix(String s1, String s, int caseno) {
        int n = s.length(), n1 = s1.length();
        int i = 0;
        while (i < n && i < n1 && s.charAt(i) == s1.charAt(i)) i++;
        int res = i+1 <= n ? i+1 : i;
        
        return res;
    }
    
    private static void printf(String format, Object... args) {
        out.format(format, args);
        System.out.format(format, args);
    }
}
