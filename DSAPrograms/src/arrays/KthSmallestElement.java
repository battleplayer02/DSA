/*package whatever //do not write package name here */
package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class KthSmallestElement {

    public static void main(String[] args) {
        //code
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
            int k = s.nextInt();
            Arrays.sort(arr);
            System.out.println(arr[k - 1]);
        }
    }
}
