package pep_test;

import java.util.*;

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int f = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (f == 0) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            f = f == 0 ? 1 : 0;
        }
        // print arr
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    // swap i j of a[i] a[j]'
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
/*
 * ele1 < ele2 > ele3 < ele4 > ele5 ........ (upto nth element). input {5, 4, 3,
 * 2} output {4, 5, 2, 3}
 */
