/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Time_And_Space;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Radix_Sort {

    public static void radixSort(int[] arr) {
        // write code here    
        int max = -1000_000_000;
        for (int ele : arr) {
            max = Math.max(ele, max);
        }

        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }

    }

    public static void countSort(int[] arr, int exp) {
        // write code here
        int max = 9;
        int min = 0;
        int freq[] = new int[max - min + 1];
        int newarr[] = new int[arr.length];

        for (int ele : arr) {
            int newEle = ele;
            ele = ele / exp;
            ele = ele % 10;
            freq[ele - min]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (i > 0) {
                freq[i] += freq[i - 1];
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int ele = arr[i];
            ele = ele / exp;
            ele = ele % 10;
            int pos = freq[ele - min];
            newarr[pos - 1] = arr[i];
            freq[ele - min]--;
        }
        for (int i = 0; i < newarr.length; i++) {
            arr[i] = newarr[i];
        }

        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }
}
