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
public class Friends_Paiing {

    public static void main(String[] args) throws Exception {
        // write your code here
        int n = new Scanner(System.in).nextInt();
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        for (int e : dp) {
            System.out.print(e + " ");
        }
        System.out.println(dp[n]);
    }

}
