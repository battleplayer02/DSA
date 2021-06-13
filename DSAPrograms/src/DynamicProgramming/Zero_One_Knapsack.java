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
public class Zero_One_Knapsack {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int vls[] = new int[n];
        for (int i = 0; i < n; i++) {
            vls[i] = scn.nextInt();
        }
        int wts[] = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }
        int cap = scn.nextInt();

        System.out.println(zeroOneKnapsack(wts, vls, cap));

    }

    public static int zeroOneKnapsack(int wts[], int vls[], int cap) {
        int dp[][] = new int[wts.length + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            int wt = wts[i - 1];
            int vl = vls[i - 1];
            for (int j = 1; j < dp[0].length; j++) {
                int inc = (j - wt >= 0) ? vl + dp[i - 1][j - wt] : 0;
                int exc = dp[i - 1][j];
                dp[i][j] = Math.max(inc, exc);
            }
        }
//        for (int[] dp1 : dp) {
//            for (int e : dp1) {
//                System.out.print(e);
//            }
//            System.out.println("");
//        }
        return dp[wts.length][cap];
    }
}
