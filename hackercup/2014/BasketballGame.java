/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FacebookHackerCup;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Facebook Hacker Cup 2013 (Qualification Round)
 * @author huseyngasimov
 */
public class BasketballGame {
    private static class Player {
        String name;
        int shot_percentage, height, playing_time, draftn;
        
        public Player (String n, int sp, int h) {
            name = n;
            shot_percentage = sp;
            height = h;
        }
    }
    
    public static final Comparator<Player> BY_SP_HEIGHT = new By_Sp_height();
    public static final Comparator<Player> PLAYS_FIRST = new PlaysFirst();
    
    
    public static void main(String[] args) {
        String curdir = "io//fb//qualification//BasketballGame//";
        try {
            BufferedReader br = new BufferedReader(new FileReader(curdir + "basketball_game.txt"));
            FileWriter fstream = new FileWriter(curdir + "out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            String sm = br.readLine();
            int m = Integer.parseInt(sm);
            
            for (int caseno = 1; caseno <= m; caseno++) {                 
                try {
                    String[] NMP = br.readLine().split(" ");
                    int N = Integer.parseInt(NMP[0]);
                    int M = Integer.parseInt(NMP[1]);
                    int P = Integer.parseInt(NMP[2]);
                    
                    Player[] players = new Player[N];
                    for (int i = 0; i < N; i++) {
                        String[] line = br.readLine().split(" ");
                        players[i] = new Player(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                    }
                    
                    Arrays.sort(players, BY_SP_HEIGHT);                    
                    for (int i = 0; i < N; i++) players[i].draftn = i+1; // give draft numbers
                    
                    TreeSet<Player> team1 = new TreeSet<Player>(PLAYS_FIRST);
                    TreeSet<Player> team1_subs = new TreeSet<Player>(PLAYS_FIRST);                    
                    TreeSet<Player> team2 = new TreeSet<Player>(PLAYS_FIRST);
                    TreeSet<Player> team2_subs = new TreeSet<Player>(PLAYS_FIRST);
                    
                    for (int i = 0; i < N; i += 2) team1.add(players[i]);
                    for (int i = 1; i < N; i += 2) team2.add(players[i]);
                    
                    while (team1.size() > P) team1_subs.add(team1.pollFirst());
                    while (team2.size() > P) team2_subs.add(team2.pollFirst());                    

                    if (team1_subs.size() > 0)
                        for (int rotation = 0; rotation < M; rotation++) 
                            rotate(team1, team1_subs);                        
                    
                    if (team2_subs.size() > 0)
                        for (int rotation = 0; rotation < M; rotation++) 
                            rotate(team2, team2_subs);                        
                    
                    
                    String[] result = new String[team1.size() + team2.size()];
                    int i = 0;
                    for (Player p: team1) result[i++] = p.name;                        
                    for (Player p: team2) result[i++] = p.name;
                    Arrays.sort(result);
                    
                    print("Case #" + caseno + ":");
                    out.write("Case #" + caseno + ":");
                    for (String pname : result) { print(" " + pname); out.write(" " + pname); }
                    println(""); out.write("\n");
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }

            br.close();
            out.close();
            fstream.close();
        }
        catch(Exception ex) {
            System.err.println(ex);
        }
    }
    
    private static void rotate(TreeSet<Player> team, TreeSet<Player> team_subs) {
        for (Player team_p: team) team_p.playing_time++; // update playing times
        
        if (team_subs.size() > 0) {
            team.add(team_subs.pollLast());        
            team_subs.add(team.pollFirst());         
        }
    }
    
    private static class By_Sp_height implements Comparator<Player> {
        @Override
        public int compare(Player t, Player t1) {
            if (t.shot_percentage != t1.shot_percentage) return t1.shot_percentage - t.shot_percentage;
            return t1.height - t.height;
        }
       
    }
    
    private static class PlaysFirst implements Comparator<Player> {
        @Override
        public int compare(Player t, Player t1) {
            if (t.playing_time != t1.playing_time) return t1.playing_time - t.playing_time;
            return t1.draftn - t.draftn;
        }
       
    }
    
    static void writeLineToFile(BufferedWriter out, String s) {
        try {
            out.write(s + "\n");
        } catch (IOException ex) {
            println(ex);
        }
    }

    private static void println(Object o) { System.out.println(o);}
    private static void print(Object o) { System.out.print(o);}
}
