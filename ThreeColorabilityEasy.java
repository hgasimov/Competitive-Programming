/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoder;

/**
 *
 * @author huseyngasimov
 */
public class ThreeColorabilityEasy {
    private static char other(char c1, char c2) {
        if ('r' != c1 && 'r' != c2) return 'r';
        if ('g' != c1 && 'g' != c2) return 'g';
        return 'b';
    }
    
    private static void printarr(char[] arr) {
        for(char c: arr) {
            System.out.print(c); System.out.print(' ');
        }
        println("");
    }
    
    public static String isColorable(String[] cells) {
        if(cells.length < 2) return "Yes";
        
        int W = cells[0].length();        
        char[] upper = new char[W+1];
        char[] lower = new char[W+1];
        
        // ------ color the first row -----------
        char[] rowcells = cells[0].toCharArray();
        if (rowcells[0] == 'Z') {
            upper[0] = 'r'; upper[1] = 'b';
            lower[0] = 'g'; lower[1] = 'r';
        }
        else {
            upper[0] = 'b'; upper[1] = 'r';
            lower[0] = 'r'; lower[1] = 'g';
        }
        for(int i = 1; i < W; i++) {
            if (rowcells[i] == 'Z') {
                lower[i+1] = upper[i]; // opposite
                upper[i+1] = other(lower[i], lower[i+1]);
            }
            else {
                upper[i+1] = lower[i];
                lower[i+1] = other(upper[i], upper[i+1]);
            }
        }
        
        //print("Upper: "); printarr(upper);
        //print("Lower: "); printarr(lower);
        
        
        // ------ try to color the other rows -----------
        for(int rowid = 1; rowid < cells.length; rowid++) {
            rowcells = cells[rowid].toCharArray();
            
            // flip the upper & lower
            char[] tmp = lower;
            lower = upper; upper = tmp;
            
            if (rowcells[0] == 'Z') {
                lower[1] = upper[0]; // opposite
                lower[0] = other(upper[0], upper[1]);
            }
            else {
                lower[0] = upper[1]; // opposite
                lower[1] = other(upper[0], upper[1]);
            }
            
            for (int colid = 1; colid < W; colid++)
                if (rowcells[colid] == 'Z') {
                    if (lower[colid] == upper[colid+1]) return "No";
                    lower[colid+1] = upper[colid];
                }
                else {
                    if (lower[colid] != upper[colid+1]) return "No";
                    lower[colid+1] = other(upper[colid], upper[colid+1]);
                }                    
                
        }
        
        return "Yes";
    }
    
    public static void main(String[] args) {
        String[] cells = {"ZZZZ"
,"ZZZZ"
,"ZZZZ"};
        println(isColorable(cells));
        //println(other('g', 'r'));
    }
    
    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
