/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class MinimizeTheMaximumDifferenceOfAnArray {
    public static int Solution(int arr[],int n,int k){
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
         
        return 1;
    }
}
