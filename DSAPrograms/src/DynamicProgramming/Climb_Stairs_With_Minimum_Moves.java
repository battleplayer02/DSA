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
public class Climb_Stairs_With_Minimum_Moves {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int jumps[] = new int[n];
        for (int i = 0; i < jumps.length; i++) {
            jumps[i] = s.nextInt();
        }
        Integer dp[] = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (jumps[i] > 0) {
                int min = 1000_000_000;
                int jump = jumps[i];
                for (int j = 1; j <=jump  && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(dp[i + j], min);
                    }
                }
                if (min != 1000_000_000) {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);
    }
}
