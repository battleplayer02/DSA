/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GetMinDiff {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            
            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {

    int getMinDiff(int[] arr, int n, int k) {
        getMinDifferrence(arr, k, 0);
        return min;
    }

    public static int getMax(int[] inputArray) {
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static int getMin(int[] inputArray) {
        int minValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < minValue) {
                minValue = inputArray[i];
            }
        }
        return minValue;
    }

    static int min = Integer.MIN_VALUE;
    
    void getMinDifferrence(int arr[], int k, int i) {
//        System.out.println("hello");
        if (arr.length-1 == i) {
            min = Math.min(min,getMax(arr)-getMin(arr));
//            System.out.println("k");
            return;
        }

        int[] arr1 = arr;
        arr1[i] += k;
        getMinDifferrence(arr1, k, i + 1);

        int[] arr2 = arr;
        arr2[i] -= k;
        getMinDifferrence(arr1, k, i + 1);
    }
}
