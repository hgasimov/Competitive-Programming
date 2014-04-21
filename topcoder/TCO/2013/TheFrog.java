package topcoder;

/*
 * TCO13 Round 1A Div1, 500 point problem 
 */
public class TheFrog {    
    public static double getMinimum(int D, int[] L, int[] R) {
        double[] dL = toDoubleArray(L);
        double[] dR = toDoubleArray(R);
        
        double minStep = getMaxIntervalLength(dL, dR);
        
        boolean found = false;
        double inc;
        while (!found) {
            found = true;
            for (int i = 0; i < dL.length; i++) {
                inc = stepIncrease(minStep, dL[i], dR[i]);
                if (inc > 0) {                    
                    found = false;
                    minStep += inc;
                    break;
                }
            }
        }
        
        return minStep;
    }    

    private static double getMaxIntervalLength(double[] L, double[] R) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < L.length; i++)
            max = Math.max(max, R[i] - L[i]);
        return max;
    }

    private static double stepIncrease(double minStep, double lo, double hi) {
        double n = Math.floor(Math.rint(lo / minStep * 1000000000) / 1000000000);
        double nextStep = (n + 1) * minStep;        
        
        return nextStep < hi ? (hi - nextStep) / (n + 1) : 0;
    }

    private static double[] toDoubleArray(int[] L) {
        double[] a = new double[L.length];
        for (int i = 0; i < L.length; i++)
            a[i] = (double) L[i];
        return a;
    }
    
    public static void main(String[] args) {
        int D = 444;
        int[] L = {336, 402, 233, 397, 153, 297};
        int[] R = {340, 405, 237, 399, 156, 300};
        System.out.println(getMinimum(D, L, R));
    }
}
