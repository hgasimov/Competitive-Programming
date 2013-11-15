/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FacebookHackerCup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *
 * @author huseyngasimov
 */
public class FindMin {
    private String a, b, c, r;
    private int k, n;
    private int[] m, sm;
    
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("find_the_mintxt.txt"));
            String sT = br.readLine();
            int T = Integer.parseInt(sT);
            
            for (int caseno = 1; caseno <= T; caseno++) { 
                try {
                    //br.readLine(); br.readLine();
                    String[] sNK = br.readLine().split(" ");
                    String[] sABCR = br.readLine().split(" ");             

                    FindMin fMin = new FindMin(sABCR[0], 
                                            sABCR[1], 
                                            sABCR[2], 
                                            sABCR[3], 
                                            sNK[0], 
                                            sNK[1]); 

                    System.out.println("Case #" + caseno + ": " + fMin.calMin());
                }
                catch(Exception ex) {
                    System.out.println("Case #" + caseno + ": " + 0 + ", " + ex);
                }
            }
            
            br.close();
        }
        catch(Exception ex) {
            System.err.println(ex);
        }                
    }
    
    public FindMin(String a1, String b1, String c1, String r1, String n1, String k1) {
        a = a1;
        b = b1;
        c = c1;
        r = r1;
        k = Integer.parseInt(k1);   
        n = Integer.parseInt(n1);                
    }
    
    public int calMin() {        
        init_m();
        Arrays.sort(sm);

        int i;
        
        int prev_v_rm = -1;
        int prev_i = -1;
        boolean increased = false;
        for (i = k; i < n; i++) {
            // find min
            for(int j = 0; j < k; j++)
                if (j > 0 && sm[j] - sm[j-1] > 1) {                    
                    int v_rm = m[i%k]; // value to be removed
                    m[i%k] = sm[j-1] + 1; // value to be added to the j-th position
                    //System.out.println("| " + v_rm + ", m[" + i + "]= " + m[i]);
                    update_sm(j, m[i%k], v_rm);                
                    break;
                } 
                else if (j == 0 && sm[j] > 0) {                    
                    int v_rm = m[i%k]; // value to be removed
                    m[i%k] = 0; // value to be added to the j-th position
                    //System.out.println("| " + v_rm + ", m[" + i + "]= " + m[i]);
                    update_sm(j, m[i%k], v_rm);                
                    break;
                }                
                else if (j == k-1 && sm[j] - sm[j-1] < 2) {                    
                    int v_rm = m[i%k]; // value to be removed
                    m[i%k] = j+1; // value to be added to the j+1-th position
                    //System.out.println("| " + v_rm + ", m[" + i + "]= " + m[i%k]);
                    update_sm(j+1, m[i%k], v_rm); 
                    
                    if (!increased) {                        
                        int add_times = (n - i)/(k + 1);
                        if (i + add_times*(k + 1) < n) {
                            i += add_times*(k + 1);
                            round_m(add_times); 
                        }
                        increased = true; 
                    }
                }
        }
        
        return m[(i-1)%k];
    }
    
    private void round_m(int rcount) {
        //int end = m[k-1];
        int rc = rcount % k;
        
        int[] cp_m = new int[k];
        System.arraycopy(m, 0, cp_m, 0, k);
        
        int j;
        for (int i = k - 1; i > -1; i--) {
            j = i - rc;
            if (j < 0) j += k;
            m[i] = cp_m[j];
        }
        
        //m[0] = end;
    }
    
    private void print_sm() {
        System.out.println();
        
        for(int i=0; i<k; i++) 
            System.out.print(sm[i] + " ");
    }
    
    private void print_m() {
        System.out.println();
        
        for(int i=0; i<k; i++) 
            System.out.print(m[i] + " ");
    }
    
    private int find(int x) {
        int i1 = 0;
        int i2 = k-1;
        
        while (i2 - i1 > 1) {  
            //System.out.print(i1 + " " + i2);
            int i = (i2 + i1)/2;  
            //System.out.println(" " + i);
            if (x == sm[i]) return i;
            else if (x < sm[i]) i2 = i;
            else i1 = i;
        }
        
        if (x == sm[i1]) return i1;
        if (x == sm[i2]) return i2;
        
        return -1;
    }
    
    private void update_sm(int j_add, int v_add, int v_rm) {
        int j_rm = find(v_rm); // index to be removed        
        //System.out.println(j_rm);
        
        if(j_add < j_rm) {
            for (int i = j_rm; i > j_add; i--) {
                sm[i] = sm[i-1]; // here i cant be 0 because j_rm > j_add
            }
            
            sm[j_add] = v_add;
        }
        else if (j_add == j_rm) 
            sm[j_add] = v_add;
        else {
            for (int i = j_rm; i < j_add; i++) {
                if (i+1 < k) sm[i] = sm[i+1];
                else sm[i] = k;
            }
            sm[j_add-1] = v_add;
        }
        
        //print_sm();
    }
    
    private void init_m() {
        m = new int[k];
        sm = new int[k];        
        m[0] = Integer.parseInt(a);
        sm[0] = m[0];
        
        BigInteger bB = new BigInteger(b);
        BigInteger bC = new BigInteger(c);
        BigInteger bR = new BigInteger(r);        
        BigInteger bPrev = new BigInteger(a);        
        
        bPrev = bPrev.mod(bR);
        bC = bC.mod(bR);
        bB = bB.mod(bR);                
        
        for(int i = 1; i < k; i++) {
            BigInteger res = bB.multiply(bPrev).add(bC).mod(bR);
            m[i] = (int) res.longValue(); 
            sm[i] = m[i];
            bPrev = res;            
        }                
    }
}
