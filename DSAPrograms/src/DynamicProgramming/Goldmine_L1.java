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
public class Goldmine_L1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();

        int mine[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mine[i][j] = s.nextInt();
            }
        }

        int dp[][] = new int[row][col];

        for (int c = col - 1; c >= 0; c--) {
            for (int r = 0; r < row; r++) {
                if (c == col - 1) {
                    dp[r][c] = mine[r][c];
                } else if (r == 0) {
                    dp[r][c] = mine[r][c] + Math.max(dp[r][c + 1], dp[r + 1][c + 1]);
                } else if (r == row - 1) {
                    dp[r][c] = mine[r][c] + Math.max(dp[r][c + 1], dp[r - 1][c + 1]);
                } else {
                    dp[r][c] = mine[r][c] + Math.max(dp[r][c + 1], Math.max(dp[r - 1][c + 1], dp[r + 1][c + 1]));
                }
            }
        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println("");
//        }

        int maxGold = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }
        System.out.println(maxGold);
    }
}
