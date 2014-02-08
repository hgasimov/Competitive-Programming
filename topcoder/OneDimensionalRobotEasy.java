package topcoder;

/* 
 * Single Round Match 608 (Div 2)
 */
public class OneDimensionalRobotEasy {
    
    public static int finalPosition(String commands, int A, int B) {
        int pos = 0;
        
        for (int i = 0; i < commands.length(); i++)
            if (commands.charAt(i) == 'L') {
                if (pos - 1 >= -A) pos--;
            }
            else {
                if (pos + 1 <= B) pos++;
            }
        
        return pos;
    }
    
    public static void main(String[] args) {
        String command = "RRLRRLLR";
        println(finalPosition(command, 10, 10));
    }
      
    private static void println(Object o) { System.out.println(o);}
}
