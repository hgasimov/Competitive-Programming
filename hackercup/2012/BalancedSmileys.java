package FacebookHackerCup;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huseyngasimov
 */
public class BalancedSmileys {
    public static void main(String[] args) {                
        try {
            BufferedReader br = new BufferedReader(new FileReader("io_fb_qualification/balanced_smileystxt.txt"));
            FileWriter fstream = new FileWriter("io_fb_qualification/answer_balancedsmileys.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            String sm = br.readLine();
            int m = Integer.parseInt(sm);
            
            for (int caseno = 1; caseno <= m; caseno++) {                 
                String line = br.readLine();
                
                if (isBalanced(line)) {                       
                    System.out.println("Case #" + caseno + ": " + "YES");
                    writeLineToFile(out, "Case #" + caseno + ": " + "YES");
                }
                else {
                    System.out.println("Case #" + caseno + ": " + "NO"); 
                    writeLineToFile(out, "Case #" + caseno + ": " + "NO"); 
                }
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
            Logger.getLogger(BalancedSmileys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static boolean isBalanced(String s) {
        int colonIndex = s.indexOf(':');
        if (colonIndex > -1) {
            if (colonIndex < s.length()-1 && (s.charAt(colonIndex+1) == ')' || s.charAt(colonIndex+1) == '(')) {
                String sbStr = s.substring(0, colonIndex) + s.substring(colonIndex+2);
                if (isBalanced(sbStr)) {
                    //System.out.println(colonIndex + " right, " + s);
                    return true;
                }
            }            
            
            String sbStr = s.substring(0, colonIndex) + s.substring(colonIndex+1);
            return isBalanced(sbStr);
        }
        else {
            int i = 0;
            int paranWeight = 0;
            char[] cs = s.toCharArray();
            while (i < cs.length && paranWeight > -1) {
                if (cs[i] == '(')
                    paranWeight++;
                else if (cs[i] == ')')
                    paranWeight--;
                
                i++;
            }
            
            if (paranWeight == 0) return true;                
            else return false;
        }
    } 
}
