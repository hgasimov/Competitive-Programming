/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FacebookHackerCup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Facebook Hacker Cup 2013 (Qualification Round)
 * @author huseyngasimov
 */
public class SquareDetector {
    public static void main(String[] args) throws FileNotFoundException {
        String curdir = "io//fb//qualification//SquareDetector//";

        Scanner in = new Scanner(new File(curdir + "square_detector.txt"));
        PrintWriter out = new PrintWriter(curdir + "square_detector.out.txt");
        
        int T = in.nextInt();

        for (int caseno = 1; caseno <= T; caseno++) { 
            try {
                int N = in.nextInt();
                int left = -1, right = -1, top = -1, bottom = -1, width = -1;
                boolean found = false;

                for (int i = 0; i < N; i++) {
                    char[] line = in.next().toCharArray();
                    if (found) continue;

                    for (int j = 0; j < N; j++) {
                        if (left < 0) {
                            if (line[j] == '#') {
                                left = j; 
                                top = i; 
                            }                            
                        }

                        if (left >= 0 && width < 0) {
                            if (line[j] == '.') {
                                width = j - left; 
                            }
                            else if (j == N-1 && line[j] == '#') {
                                width = N - left; 
                            }

                            if (width > 0 && (i + width > N)) { // would not fit, too big
                                println("Case #" + caseno + ": NO");
                                out.println("Case #" + caseno + ": NO");
                                found = true;
                                break;
                            } 
                        }

                        if (left >= 0 && width >= 0) {
                            if ((line[j] == '.' && inside_square(left, top, width, i, j))
                                    || (line[j] == '#' && !inside_square(left, top, width, i, j))) {
                                println("Case #" + caseno + ": NO");
                                out.println("Case #" + caseno + ": NO");
                                found = true;
                                break;
                            }
                        }
                    }
                }

                if (!found) {
                    println("Case #" + caseno + ": YES");
                    out.println("Case #" + caseno + ": YES");
                }
            }
            catch(Exception ex) {
                println("Case #" + caseno + ": ERROR");
            }
        }
        
        out.flush();
    }
    
    private static boolean inside_square (int left, int top, int width, int i, int j) {
        return left <= j && (j < left + width) && top <= i && (i < top + width);        
    }    
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
