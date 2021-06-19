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
public class Two_Transaction_Stock_Buy_Sell {

    public static void main(String[] dasfasdgjaksdfgargs) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int mpist = 0;
        int leastsp = arr[0];
        int dpSp[] = new int[n];
        for (int i = 1; i < n; i++) {
            leastsp = Math.min(leastsp, arr[i]);
            mpist = arr[i] - leastsp;
            dpSp[i] = Math.max(dpSp[i - 1], mpist);
        }

        int mpibt = 0;
        int maxat = arr[arr.length - 1];
        int dpBp[] = new int[n];
        for (int i = arr.length - 2; i >= 0; i--) {
            maxat = Math.max(maxat, arr[i]);
            mpibt = maxat - arr[i];
            dpBp[i] = Math.max(mpibt, dpBp[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dpBp[i] + dpSp[i]);
        }
        System.out.println(res);
    }
}
