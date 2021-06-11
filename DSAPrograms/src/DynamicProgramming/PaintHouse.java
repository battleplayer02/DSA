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
public class PaintHouse {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = s.nextInt();
            }
        }
        int dp[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                } else {
                    if (j == 0) {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                    }
                    if (j == 1) {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][2], dp[i - 1][0]);
                    }
                    if (j == 2) {
                        dp[i][j] = arr[i][j] + Math.min(dp[i - 1][1], dp[i - 1][0]);
                    }
                }
            }
        }

        int min = 1_000_000_000;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        System.out.println(min);
    }
}
