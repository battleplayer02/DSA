package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class ArrayConsistOf012 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int arr[] = new int[n];
            int start = 0;
            int end = arr.length - 1;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s.nextInt();
            }
            HashMap<Integer, Integer> freq = new HashMap<>();
            freq.put(0, 0);
            freq.put(1, 0);
            freq.put(2, 0);

            for (int j = 0; j < arr.length; j++) {
                freq.put(arr[j], freq.get(arr[j]) + 1);
            }
            int i = 0;
            // System.out.println(freq);
            for (i = 0; i < freq.get(0); i++) {
                arr[i] = 0;
            }
            for (; i < freq.get(0) + freq.get(1); i++) {
                arr[i] = 1;
            }
            for (; i < freq.get(0) + freq.get(1) + freq.get(2); i++) {
                arr[i] = 2;
            }

            for (i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
