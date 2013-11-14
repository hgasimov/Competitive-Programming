/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

/**
 *
 * @author huseyngasimov
 */
public class IncrementAndDoubling {
    
    public static int getMin(int[] desiredArray) {
        int nchange = 0;
        boolean done = false;
        
        while(!done) {
            done = true;
            
            for (int i = 0; i < desiredArray.length; i++) {
                if (desiredArray[i] % 2 == 1) {
                    desiredArray[i] --;
                    nchange ++;
                }
                
                if (desiredArray[i] > 0) done = false;
            }
            
            if (done) break;
            //printarray(desiredArray);
            
            for (int i = 0; i < desiredArray.length; i++) {                
                desiredArray[i] /= 2;                
            }
            
            //printarray(desiredArray);
            
            nchange ++;
        }
        
        return nchange;
    }
    
    public static void main(String[] args) {
        int[] in = {7,5,8,1,8,6,6,5,3,5,5,2,8,9,9,4,6,9,4,4,1,9,9,2,8,4,7,4,8,8,6,3,9,4,3,4,5,1,9,8,3,8,3,7,9,3,8,4,4,7};
        println(getMin(in));
    }
    
    private static void printarray(int[] arr) {
        for (int i: arr) print(i + " ");
        println("");
    }
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
