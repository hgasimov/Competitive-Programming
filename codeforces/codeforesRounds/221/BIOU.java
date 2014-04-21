/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package codeforces;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Codeforces Round #221 (DIV 2)
 * @author huseyngasimov
 */
public class BIOU {
    private class Debt {
        int to, amount;
        
        Debt(int to, int amount) {
            this.to = to; this.amount = amount;
        }
    }
    
    private int solve() {
        Scanner in = new Scanner(System.in);             
        
        int n = in.nextInt();
        int m = in.nextInt();
        
        ArrayList<Debt>[] debts = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) 
            debts[i] = new ArrayList<Debt>();
        
        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int amount = in.nextInt();
            debts[from].add(new Debt(to, amount));
        }
        
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 1; i <= n; i++) 
                for (int j1 = 0; j1 < debts[i].size(); j1++) {
                    Debt dbt = debts[i].get(j1);
                    if (dbt.amount > 0 && debts[dbt.to].size() > 0) {
                        for (int j2 = 0; j2 < debts[dbt.to].size(); j2++) {
                            found = true;
                            Debt dbtTo = debts[dbt.to].get(j2);
                            int minAmount = Math.min(dbt.amount, dbtTo.amount);
                            dbt.amount -= minAmount; 
                            dbtTo.amount -= minAmount;
                            if (dbtTo.to != i) debts[i].add(new Debt(dbtTo.to, minAmount));
                            if (dbtTo.amount == 0) { debts[dbt.to].remove(j2); j2--; }
                            if (dbt.amount == 0) { debts[i].remove(j1); j1--; break; }                            
                        }
                    }                                        
                }
        }
        
        return sum(debts);
    }
    
    private int sum(ArrayList<Debt>[] debts) {
        int sum = 0;
        for (int i = 0; i < debts.length; i++) {
            for (Debt dbt : debts[i]) sum += dbt.amount;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);   
        BIOU b = new BIOU();
        out.print(b.solve());
        out.flush();
    }
}
