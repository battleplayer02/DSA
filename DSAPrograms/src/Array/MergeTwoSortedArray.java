/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 6, 7, 8, 9, 10 };
        int arr[] = merge(arr1, arr2);
        // create arrayList from array
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(list);
    }

    // function to merge two sorted arrays
    public static int[] merge(int[] a, int[] b) {
        int arr[] = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                arr[k] = a[i];
                i++;
            } else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            arr[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            arr[k] = b[j];
            j++;
            k++;
        }
        return arr;
    }
}
