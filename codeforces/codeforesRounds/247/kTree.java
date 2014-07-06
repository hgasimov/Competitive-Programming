import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Codeforces Round #247 (Div. 2), Problem C
 */
public class kTree {
    private static final int m = 1000000007;
 
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int n = in.nextInt(),
	    K = in.nextInt(),
	    d = in.nextInt();

	int[][] dp = new int[n+1][2];
	dp[0][0] = 1;

	int npath = 0;
	for (int i = 0; i < n; i++) {
	    int[][] dp_next= new int[n+1][2];

	    for (int j = i; j < n; j++) {
		if (dp[j][0] + dp[j][1] == 0) continue;

		for (int k = 1; k <= K; k++) {
		    if (j + k > n) break;
		    if (k >= d) 
			dp_next[j+k][1] = (dp_next[j+k][1] + dp[j][0]) % m;
		    else
			dp_next[j+k][0] = (dp_next[j+k][0] + dp[j][0]) % m;

		    dp_next[j+k][1] = (dp_next[j+k][1] + dp[j][1]) % m;
		}
	    }
	    
	    dp = dp_next;
	    npath = (npath + dp[n][1]) % m;
	}

	out.println(npath);
	out.flush();
    }
}