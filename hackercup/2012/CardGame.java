/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FacebookHackerCup;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huseyngasimov
 */
public class CardGame {
    private static BigInteger r = new BigInteger("1000000007");
    
    public static void main(String[] args) {                
        try {
            BufferedReader br = new BufferedReader(new FileReader("io_fb_round1/card_game.txt"));
            FileWriter fstream = new FileWriter("io_fb_round1/answer_card_game.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            String sT = br.readLine();
            int T = Integer.parseInt(sT);
            
            for (int caseno = 1; caseno <= T; caseno++) {                 
                String[] nk = br.readLine().split(" ");
                int N = Integer.parseInt(nk[0]);
                int K = Integer.parseInt(nk[1]);
                
                int[] a = new int[N];
                String[] sa = br.readLine().split(" ");
                for(int i = 0; i < N && i < sa.length; i++) 
                    a[i] = Integer.parseInt(sa[i]);
                
                Arrays.sort(a);
                
                BigInteger sum = new BigInteger(String.valueOf(0));
                BigInteger inc; // increment
                BigInteger max;
                
                for (int i = N-1; i > K-2; i--) {
                    max = new BigInteger(String.valueOf(a[i]));
                    inc = max.multiply(combination(i, K-1));
                    sum =  sum.add(inc);
                }
                
                System.out.println("Case #" + caseno + ": " + sum.mod(r).toString());
                writeLineToFile(out, "Case #" + caseno + ": " + sum.mod(r).toString());
            }
            
            br.close();
            out.close();
            fstream.close();
        }
        catch(Exception ex) {
            System.err.println(ex);
        }
    }
    
    static void writeLineToFile(BufferedWriter out, String s) {
        try {
            out.write(s + "\n");
        } catch (IOException ex) {
            Logger.getLogger(CardGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static BigInteger combination(int n, int k) {
        if (n < k) return new BigInteger("0");
        else if (k == 0) return new BigInteger("1");
        else {
            BigInteger num = new BigInteger(String.valueOf(n)); // numerator
            BigInteger mtp = new BigInteger(String.valueOf(n));
            BigInteger one = new BigInteger("1");
            
            for (int i = 1; i < k; i++) {
                mtp = mtp.subtract(one);
                num = num.multiply(mtp).mod(r);
            }
            
            //System.out.println(num.toString());
            
            BigInteger dem = new BigInteger("1"); // denominator
            mtp = new BigInteger("0");
            
            
            for (int i = 0; i < k; i++) {
                mtp = mtp.add(one);
                dem = dem.multiply(mtp).mod(r);
            }
            
            return num.multiply(dem.modInverse(r));
        }
    }
}
