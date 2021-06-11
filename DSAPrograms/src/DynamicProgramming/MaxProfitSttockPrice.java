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
public class MaxProfitSttockPrice {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int profit = 0;
        int currentProfit = 0;
        int buyingIndex = 0;
        for (int i = 1; i < n; i++) {
            currentProfit =  arr[i] - arr[buyingIndex];
            if (currentProfit < 0) {
                buyingIndex = i;
            }
            if (profit < currentProfit) {
                
                profit = currentProfit;
            }
        }
        System.out.println(profit);
    }
}
