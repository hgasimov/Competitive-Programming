package topcoder;

/*
 * TCO13 Round 1A Div1, 250 point problem 
 */
public class HouseBuilding {
    public static int getMinimum(String[] area) {
        int[][] iArea = toIntArray(area);
        
        int minLevel = getMinLevel(iArea);
        int maxLevel = getMaxLevel(iArea);        
        if (minLevel >= maxLevel) return 0;
        
        int min = Integer.MAX_VALUE;        
        for (int level = minLevel; level < maxLevel; level++)            
            min = Math.min(min, getCost(iArea, level));
            
        return min;
    }
    
    private static int[][] toIntArray(String[] area) {
        int[][] a = new int[area.length][area[0].length()];
        for (int i = 0; i < area.length; i++)
            for (int j = 0; j < area[0].length(); j++)
                a[i][j] = area[i].charAt(j) - '0';
        return a;
    }

    private static int getMinLevel(int[][] iArea) {
        int min = Integer.MAX_VALUE;
        for (int[] a : iArea)
            for (int i : a)
                min = Math.min(min, i);
        return min;
    }

    private static int getMaxLevel(int[][] iArea) {
        int max = Integer.MIN_VALUE;
        for (int[] a : iArea)
            for (int i : a)
                max = Math.max(max, i);
        return max;        
    }
    
    private static int getCost(int[][] area, int level) {
        int cost = 0;
        
        for (int[] a : area)
            for (int i : a) {
                if (i < level) 
                    cost += level - i;
                else if (i - level > 1)
                    cost += i - level - 1;
            }
        
        return cost;
    }
    
    public static void main(String[] args) {
        String[] s = {"0"};
        
        System.out.println(getMinimum(s));
    }
}
