package Array;

import java.util.Scanner;

public class RotateAnArray {

    static public void rotate(int[] a, int k) {
        k = k % a.length;
        if (k < 0) {
            k += a.length;
        }

        reverse(a, 0, a.length - k - 1);
        reverse(a, a.length - k, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    public static void reverse(int arr[], int i, int j) {
        while (i <= j) {
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
        System.out.println("Enter k");
        int k = scn.nextInt();
        rotate(arr,k);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

}
