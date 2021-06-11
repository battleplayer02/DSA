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
public class Max_Sum_Non_Adjacent_Elements {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int inc = 0;
        int exc = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                inc = arr[i];
            } else {
                int Ninc = exc + arr[i];
                int Nexc = Math.max(inc, exc);
                inc = Ninc;
                exc = Nexc;
            }
        }
        System.out.println(Math.max(exc, inc));
    }
}
