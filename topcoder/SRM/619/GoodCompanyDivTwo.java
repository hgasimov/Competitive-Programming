package topcoder;

/*
 * SRM 619 (Div 2), 250 point problem
 */
public class GoodCompanyDivTwo {
    public static int countGood(int[] superior, int[] workType) {
        int sum = 0;
        int N = superior.length;
        
        main:
        for (int i = 0; i < N; i++) {
            boolean[] marked = new boolean[105];
            marked[workType[i]] = true;
            for (int j = i; j < N; j++)
                if (superior[j] == i) {
                    if (marked[workType[j]]) continue main;
                    marked[workType[j]] = true;
                }
            sum++;
        }
        
        return sum;
    }
    
    
    public static void main(String[] args) {
        int[] sup = {-1, 0};
        int[] work = {1, 1};
        System.out.println(countGood(sup, work));
    }
}
