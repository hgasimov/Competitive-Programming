import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #247 (Div. 2), Problem A
 */
public class BlackSquare {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	String[] as = in.nextLine().split(" ");
	int[] a = new int[as.length];
	for (int i = 0; i < as.length; i++)
	    a[i] = Integer.parseInt(as[i]);
	String s = in.nextLine();
	int sum = 0;
	for (int i = 0; i < s.length(); i++)
	    sum += a[s.charAt(i) - '0'  - 1];
	
	out.println(sum);
	out.flush();
    }
}
