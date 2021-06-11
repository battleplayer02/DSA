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
public class DPTranzactionWithChargeOnTransaction {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int fee = s.nextInt();
        System.out.println(maxProfit(arr, fee));
    }

    private static int maxProfit(int[] arr, int fee) {
        int oBSP = 0;
        int oSSP = 0;
        for (int day = 0; day < arr.length; day++) {
            if (day == 0) {
                oSSP = 0;
                oBSP = -arr[0];
            } else {
                int nBSP = Math.max(oSSP - arr[day], oBSP);
                int nSSP = Math.max(oSSP, oBSP + arr[day]);
                oBSP = nBSP;
                oSSP = nSSP;
            }
        }
        return oSSP;
    }
}
