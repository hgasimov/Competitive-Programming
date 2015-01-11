import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #247 (Div. 2), Problem B
 */
public class ShowerLine {
    private static int[][] g = new int[5][5];

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	for (int i = 0; i < 5; i++) {
	    String[] line = in.nextLine().split(" ");
	    for (int j = 0; j < 5; j++)
		g[i][j] = Integer.parseInt(line[j]);
	}
	
	out.println(maxHappiness(new boolean[5], new int[5], 0));
	out.flush();
    }

    private static int maxHappiness(boolean[] marked, int[] line, int level) {
	if (level == 5) {
	    int hap = 0;
	    for (int i = 0; i < 5; i++)
		for (int j = i; j < 4; j += 2)
		    hap += g[line[j]][line[j+1]] + g[line[j+1]][line[j]];
	    return hap;
	}
	else {
	    int max = Integer.MIN_VALUE;
	    for (int i = 0; i < 5; i++)
		if (!marked[i]) {
		    marked[i] = true;
		    line[level] = i;
		    max = Math.max(max, maxHappiness(marked, line, level+1));
		    marked[i] = false;
		}
	    return max;
	}
    }
}
