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
public class ClimbStairsWithVariableJumps {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int jumps[] = new int[n];
        for (int i = 0; i < jumps.length; i++) {
            jumps[i] = s.nextInt();
        }

        int dp[] = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            int j = jumps[i];
            for (int k = 1; k < j + 1 && j < dp.length; k++) {
                dp[i] += dp[i + k];
            }
        }
        System.out.println(dp[0]);
    }
}
