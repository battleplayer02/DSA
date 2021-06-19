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
public class Count_Sort {

    public static void countSort(int[] arr, int min, int max) {
        //write your code here
        int freq[] = new int[max - min + 1];
        int newarr[] = new int[arr.length];

        for (int ele : arr) {
            freq[ele - min]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (i > 0) {
                freq[i] += freq[i - 1];
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int ele = arr[i];
            int pos = freq[ele - min];
            newarr[pos - 1] = arr[i];
            freq[ele - min]--;
        }
        for (int i = 0; i < newarr.length; i++) {
            arr[i] = newarr[i];
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }

}
