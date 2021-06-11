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
public class Target_Sum_Subset {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int target = s.nextInt();

        boolean dp[][] = new boolean[arr.length + 1][target + 1];
        for (int idx = 0; idx < arr.length + 1; idx++) {
            for (int currentTarget = 0; currentTarget < target + 1; currentTarget++) {
                if (currentTarget == 0) {
                    dp[idx][currentTarget] = true;
                } else if (idx == 0) {
                    dp[idx][currentTarget] = false;
                } else {
                    if (dp[idx - 1][currentTarget]) {
                        dp[idx][currentTarget] = true;
                    } else {
                        int remainingTarget = currentTarget - arr[idx - 1];
                        if (remainingTarget >= 0 && dp[idx - 1][remainingTarget]) {
                            dp[idx][currentTarget] = true;
                        } else {
                            dp[idx][currentTarget] = false;
                        }
                    }
                }
                System.out.print(dp[idx][currentTarget] + " | ");
            }
            System.out.println("");
        }

        System.out.println(dp[arr.length][target]);
    }
}
