/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FacebookHackerCup;

import java.io.*;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huseyngasimov
 */
public class Security {
    public static final Comparator<String> STRCOMPARATOR = new CompareStr();
    private int m, length;
    private String k1, k2;
    private String[] k1p, k2p;
    //private String[][] adapts_matrix;
    private Object[] adp_mat;
    
    
    private static class CompareStr implements Comparator<String> {
        @Override
        public int compare(String t, String t1) { 
            if(t == null && t1 == null) return 0;
            if(t == null) return 1;
            if(t1 == null) return -1;
            
            char[] ct = t.toCharArray();
            char[] ct1 = t1.toCharArray();            
            
            for(int i = 0; i < ct.length && i < ct1.length; i++) {
                int rs = cmpChar(ct[i],ct1[i]);
                if(rs != 0) return rs;
            }
                
            return 0;
        }
        
        private int cmpChar(char c, char c1) {
            if(c == c1) return 0;
            else if(c == '?') {
                if(c1 == 'a') return 0;
                else return -1;
            }
            else if(c1 == '?') {
                if(c == 'a') return 0;
                else return 1;
            }
            else if((int)c < (int)c1) return -1;
            else return 1;
        }
    }
    
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("io_fb_round1/security.txt"));
            FileWriter fstream = new FileWriter("io_fb_round1/answer_security.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            String sT = br.readLine();
            int T = Integer.parseInt(sT);
            
            for (int caseno = 1; caseno <= T; caseno++) {                 
                String sm = br.readLine();
                String sk1 = br.readLine();
                String sk2 = br.readLine();
                
                Security sec = new Security(Integer.parseInt(sm), sk1, sk2); 
                String k = sec.findK();
                //String k = String.format("%2d", 1); 
                if(k == null) k = "IMPOSSIBLE";
                System.out.println("Case #" + caseno + ": " + k);
                writeLineToFile(out, "Case #" + caseno + ": " + k);
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
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Security(int m1, String s1, String s2) {
        m = m1;
        k1 = s1;
        k2 = s2;
        
        k1p = new String[m];
        k2p = new String[m];        
        length = k1.length() / m;
        
        // init k1p and k2p
        for(int i = 0; i < m; i++) {
            k1p[i] = k1.substring(i*length, i*length + length);
            k2p[i] = k2.substring(i*length, i*length + length);
        }                   
    }
    
    public String findK() {
        // init adapts_matrix
        //adapts_matrix = new String[m][m]; 
        adp_mat = new Object[m];
        
        for(int i=0; i<m; i++)
            adp_mat[i] = new TreeMap<String, Integer>();
        
        for(int i = 0; i < m; i++) {   
            for (int j = 0; j < m; j++) {                
                String s = adapts(k1p[i], k2p[j]);
                //adapts_matrix[i][j] = s + " " + String.format("%d", j);   
                if(s != null) {                     
                    ((TreeMap<String, Integer>) adp_mat[i]).put(s + " " + String.format("%d", j), j); 
                }
            }            
        }

        // if some part of k1 does not adapt to any part of k2
        for(int i = 0; i < m; i++) 
            if(((TreeMap<String, Integer>) adp_mat[i]).size() == 0) return null;
        
        TreeSet<Integer> avSet = new TreeSet<Integer>();
        for(int i = 0; i < m; i++) avSet.add(i);
        return recFind(0, avSet);
        //return "ok";
    }
    
    private String recFind(int level, TreeSet<Integer> availSet) {
        String minPref = null;
        TreeMap<String, Integer> srtMap = (TreeMap<String, Integer>) adp_mat[level];
        
        while (!srtMap.isEmpty()) {
            Entry<String, Integer> firstEntry = srtMap.pollFirstEntry();            
            boolean removed = availSet.remove(firstEntry.getValue());
            if(!removed) continue; // if it's not in the availSet
            
            minPref = firstEntry.getKey().split(" ")[0];
            
            if(level == m-1) return minPref;
            else {
                String minSuff = recFind(level+1, availSet); 
                if(minSuff != null) return minPref + minSuff;
            }
            
            availSet.add(firstEntry.getValue());
        }
        
        return null;
    }    
    
    /** 
     * whether s2 can be adapted to s1
     * returns the adapted value if it can be adapted
     *         null if it can not be adapted
     **/   
    private String adapts(String s1, String s2) {
        if(s1.length() != s2.length()) return null;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        
        for(int i = 0; i < cs1.length; i++) 
            if(cs1[i] == '?')
                if(cs2[i] == '?') {
                    cs1[i] = 'a';
                    cs2[i] = 'a';                    
                }
                else cs1[i] = cs2[i];           
            else 
                if(cs2[i] == '?') 
                    cs2[i] = cs1[i];
                else if(cs1[i] != cs2[i]) return null;
        
        return String.valueOf(cs1);
    }    
}
