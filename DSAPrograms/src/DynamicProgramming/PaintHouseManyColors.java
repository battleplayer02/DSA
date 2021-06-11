/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class PaintHouseManyColors {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int noh = s.nextInt();
        int nop = s.nextInt();
        int cost[][] = new int[noh][nop];
        for (int r = 0; r < noh; r++) {
            for (int c = 0; c < nop; c++) {
                cost[r][c] = s.nextInt();
            }
        }
        int dp[][] = new int[noh][nop];
        for (int r = 0; r < noh; r++) {
            if (r == 0) {
                dp[r] = cost[r];
            } else {
                for (int c = 0; c < nop; c++) {
                    int min = 1_000_000_000;
                    for (int i = 0; i < nop; i++) {
                        if (i != c) {
                            min = Math.min(min, dp[r][i]);
                        }
                    }
                    System.out.println(min);
                    dp[r][c] = min + cost[r][c];
                }
            }
        }
        int min = 1_000_000_000;
        for (int i = 0; i < nop; i++) {
            min = Math.min(min, dp[noh - 1][i]);
        }
        System.out.println(min);
    }
}
