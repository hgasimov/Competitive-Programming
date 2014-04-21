/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * Codeforces Round #216 (Div. 2)
 * @author huseyngasimov
 */
public class ValeraElections {
    private static Stack<Road>[] graph;
    private static boolean[] marked;
    
    private static class Road {
        int other; 
        boolean problematic;
        public Road(int o, boolean prob) { other = o; problematic = prob; }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);        
        
        int n = in.nextInt(); // number of districts        
        graph = (Stack<Road>[]) new Stack[n];                        
        for (int i = 0; i < n; i++) { graph[i] = new Stack<Road>(); }
        
        for (int i = 0; i < n - 1; i++) {            
            int xi = in.nextInt() - 1;
            int yi = in.nextInt() - 1;
            int ti = in.nextInt();
            graph[xi].add(new Road(yi, ti == 2));
            graph[yi].add(new Road(xi, ti == 2));
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        marked = new boolean[n];
        DFS_Heads(0, stack);
        out.println(stack.size());
        for (int i : stack) out.print((i+1) + " ");
        
        out.flush();
    }
    
    private static Stack<Integer> DFS_Heads(int root, Stack<Integer> stack) {
        //println("Searchin at" + root);
        marked[root] = true;
        for (Road road_to_child: graph[root]) {
            if (marked[road_to_child.other]) continue;
            
            int prev_size = stack.size();
            DFS_Heads(road_to_child.other, stack); 
            if (road_to_child.problematic && stack.size() == prev_size) {                
                stack.add(road_to_child.other);
            }
        }
        
        return stack;
    }
}
