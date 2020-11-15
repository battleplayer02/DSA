/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class MinMax {
    static int min,max;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        int start = 0;
        int end = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        
        min = arr[0];
        max = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        System.out.println("Min: " + min + "\nMax: " + max);
        
    }
}
