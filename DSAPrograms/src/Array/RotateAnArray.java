package Array;

import java.util.Scanner;

public class RotateAnArray {
    
    public void rotate(int[] arr,int k){
        
    }
    
    public static void reverse(int arr[],int i,int j){
        while(i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        reverse(arr, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
    
}
