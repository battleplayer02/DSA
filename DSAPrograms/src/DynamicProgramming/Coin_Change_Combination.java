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
public class Coin_Change_Combination {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int amt = s.nextInt();

        int dp[] = new int[amt + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int currentAmt = 1; currentAmt < dp.length; currentAmt++) {
                int remAmt = currentAmt - arr[i];
                if (remAmt >= 0) {
                    dp[currentAmt] += dp[remAmt];
                }
            }
        }
//        for (int e : dp) {
//            System.out.print(e + " ");
//        }

        System.out.println(dp[amt]);
    }
}
