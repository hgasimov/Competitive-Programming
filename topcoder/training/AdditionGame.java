import java.util.PriorityQueue;

public class AdditionGame {
    public static int getMaximumPoints(int A, int B, int C, int N) {
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	pq.add(-A); pq.add(-B); pq.add(-C);
	int p = 0;
	for (int i = 0; i < N; i++) {
	    int X = pq.poll();
	    p += -X;
	    if (X <= -1) X++;
	    pq.add(X);
	}

	return p;
    }

    public static void main(String[] args) {
	System.out.println(getMaximumPoints(3, 4, 5, 3));
    }
}