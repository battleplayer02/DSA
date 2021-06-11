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
public class InfiniteTransactionMaxProfitStocks {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] arr) {
        int buy = 0;
        int sell = 0;
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                sell = i;
            } else {
                profit += arr[sell] - arr[buy];
                sell = buy = i;
            }
        }
        return profit;
    }
}
