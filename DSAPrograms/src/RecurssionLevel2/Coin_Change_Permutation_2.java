/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class Coin_Change_Permutation_2 {

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        // write your code here
        if (amtsf >= tamt) {
            if (amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            coinChange(coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(coins, 0, amt, "");
    }
}
