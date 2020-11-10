/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaprograms.Arrays;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class MoveAllNegativeToRight {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
                i++;
            } else {
                i++;
            }
        }

        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
