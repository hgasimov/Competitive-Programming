public class FoxSequence {
    public static String isValid(int[] seq) {
	if (seq.length < 5) return "NO";
	int i = 0;
	i = pos_neg_flat(seq, i, 1); // positive 
	if (i < 0) return "NO";

	i = pos_neg_flat(seq, i-1, 2); // negative
        if (i < 0) return "NO";

	i = pos_neg_flat(seq, i-1, 3); // flat
        if (i < 0) return "NO";

	i = pos_neg_flat(seq, i-1, 1); // positive
        if (i < 0) return "NO";

	i = pos_neg_flat(seq, i-1, 2); // negative
        if (i < 0) return "NO";

	return i == seq.length ? "YES": "NO";
    }

    private static int pos_neg_flat(int[] seq, int start, int type) {
	if (start > seq.length -2) return -1;
	int cd = seq[start+1] - seq[start];

        if (type == 1 && cd <= 0) return -1; // positive
	if (type == 2 && cd >= 0) return -1; // negative
	if (type == 3 && cd != 0) return start; // flat

	int i = start+1;
	while (i < seq.length && seq[i] - seq[i-1] == cd) i++;
	return i;
    }

    public static void main(String[] args) {
	int[] seq = {1,2,3,4,5,4,3,2,2,2,3,4,5,6,4};
	System.out.println(isValid(seq));
    }
}