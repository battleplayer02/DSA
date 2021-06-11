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
public class MinimumJumps {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Integer dp[] = new Integer[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            System.out.println(i);
            if (arr[i] > 0) {
                int min = 1_000_000_000;
                for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(dp[i + j], min);
                    }
                }
                if (min == 1_000_000_000) {
                    dp[i] = null;
                } else {
                    dp[i] = min + 1;
                }
            }
        }
        System.out.println(dp[0]);
    }
}
