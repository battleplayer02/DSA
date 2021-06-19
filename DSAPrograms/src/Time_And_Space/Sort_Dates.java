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
public class Sort_Dates {

    public static void sortDates(String[] arr) {
        // write your code here
        countSort(arr, 1000000, 100, 32);  //days
        countSort(arr, 10000, 100, 13);  //month
        countSort(arr, 1, 10000, 2501);  //year
    }

    public static void countSort(String[] arr, int div, int mod, int range) {
        // write your code here
        int freq[] = new int[range];
        String newarr[] = new String[arr.length];

        for (String ele : arr) {
            int newele = Integer.parseInt(ele, 10);
            newele = newele / div;
            newele = newele % mod;
            freq[newele - 0]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (i > 0) {
                freq[i] += freq[i - 1];
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int ele = Integer.parseInt(arr[i], 10);
            ele = ele / div;
            ele = ele % mod;
            int pos = freq[ele - 0];
            newarr[pos - 1] = arr[i];
            freq[ele - 0]--;
        }
        for (int i = 0; i < newarr.length; i++) {
            arr[i] = newarr[i];
        }

    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }
}
