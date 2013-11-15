/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FacebookHackerCup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author huseyngasimov
 */
public class BeautifulStrings {
    public static void main(String[] args) {                
        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new FileReader("beautiful_stringstxt.txt"));
            String sm = br.readLine();
            int m = Integer.parseInt(sm);
            
            for (int caseno = 1; caseno <= m; caseno++) {                            
                char[] cs = br.readLine().toLowerCase().toCharArray(); // character string
                int[] letterCount = new int[26];
                int ascii; // ascii code of the letter
                for(char lt:cs) {
                    ascii = (int)lt;
                    if (ascii > 96 && ascii < 123) 
                        letterCount[ascii-97]++;
                     
                }

                Arrays.sort(letterCount);
                /* for(int i:letterCount) 
                    if (i != 0)
                        System.out.println(i); */

                int score = 0;
                for (int i = letterCount.length - 1; (i >= 0) && (letterCount[i] != 0) ; i--)
                    score += letterCount[i]*(i+1);

                System.out.println("Case #" + caseno + ": " + score);
            }
            
            br.close();
        }
        catch(Exception ex) {
            System.err.println(ex);
        }
    }
    
}
