package FacebookHackerCup;

import java.io.*;
import java.math.BigInteger;

/**
 * Facebook Hacker Cup Round 1 (15 point)
 * @author huseyngasimov
 */
public class Labelmaker {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("io/fb/round1/labelmaker.txt"));
            FileWriter fstream = new FileWriter("io/fb/round1/out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            String sT = br.readLine();
            int T = Integer.parseInt(sT);
            
            for (int caseno = 1; caseno <= T; caseno++) {      
                String[] LN = br.readLine().split(" ");
                String L = LN[0];
                BigInteger N = new BigInteger(LN[1]);
                
                BigInteger sum = BigInteger.ZERO;
                BigInteger icount = BigInteger.ONE;
                BigInteger len = new BigInteger(String.valueOf(L.length()));
                
                int i = 0;
                while (sum.compareTo(N) < 0) {
                    icount = icount.multiply(len);
                    sum = sum.add(icount);
                    i++;
                }
                
                String lastlabel = "";
                if (sum.compareTo(N) == 0) {
                    char lastchar = L.charAt(len.intValue()-1);
                    for (int j = 0; j < i; j++) lastlabel += lastchar;
                }
                else {                    
                    sum = sum.subtract(icount);
                    icount = icount.divide(len);
                    
                    BigInteger[] index = new BigInteger[i];
                    N = N.subtract(sum).subtract(BigInteger.ONE);
                    
                    for (int j = 0; j < i; j++) {
                        index[j] = N.divide(icount);                       
                        N = N.subtract(index[j].multiply(icount));
                        icount = icount.divide(len);
                        lastlabel += L.charAt(index[j].intValue());
                    }
                }
                
                System.out.println("Case #" + caseno + ": " + lastlabel);
                writeLineToFile(out, "Case #" + caseno + ": " + lastlabel);
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
            System.err.println(ex);
        }
    }
}
