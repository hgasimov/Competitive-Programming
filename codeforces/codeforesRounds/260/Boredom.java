package codeforces;

import java.io.PrintWriter;
import java.util.*;


public class Boredom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = readArray(in, n);
        
        // count numbers
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i : a) {
            Integer val = nums.get(i);
            if (val == null)
                nums.put(i, 1);
            else
                nums.put(i, val + 1);
        }
        
        int N = nums.size();
        long[][] b = new long[N][2];
        int j = 0;
        for (int I : nums.keySet()) {
            b[j][0] = I;
            b[j++][1] = nums.get(I);
        }
        
        Arrays.sort(b, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });
        
        long[] max = new long[N];
        max[0] = b[0][0] * b[0][1];
        for (int i = 1; i < N; i++) {
            if (i == 1 && b[0][0] + 1 == b[1][0]) {
                max[1] = Math.max(max[0], b[1][0] * b[1][1]);
            }
            else {
                if (b[i - 1][0] + 1 == b[i][0]) {
                    max[i] = Math.max(b[i][0] * b[i][1] + max[i-2], max[i-1]);
                }
                else {
                    max[i] = max[i-1] + b[i][0] * b[i][1];
                }
            }
        }

        out.println(max[N-1]);
        out.flush();
    }

    private static int[] readArray(Scanner in, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        return a;
    }
}
