package topcoder;

import java.util.ArrayList;
import java.util.List;

/*
 * SRM 619 (Div 2), 500 point problem
 */
public class ChooseTheBestOne {
    public static int countNumber(int N) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= N; i++) players.add(i);
        
        int i = 0;
        long say = 1, turn = 1, threshold = 1; 
        while (players.size() > 1) {
            if(threshold == say) {
                players.remove(i);
                say = 1;
                turn++;
                threshold = turn*turn*turn;
            }
            else {                
                i += (threshold - say) % players.size();
                say = threshold;
            }            
            
            i  %=  players.size();
        }
        
        return players.get(0);
    }
    

    public static void main(String[] args) {
        System.out.println(countNumber(1506));
    }
}
