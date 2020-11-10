package dsaprograms.Arrays;

import java.util.*;

public class ReverseAnArray{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        int start = 0;
        int end = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        while(end>start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}