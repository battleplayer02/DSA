/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsaprograms.Recurssion;

/**
 *
 * @author Administrator
 */
public class PrintArrayDecending {
    static int arr[] = {10,20,30,40,50,60,70,80,90,100};
    public static void fun(int i,int[] arr){
        if(i<0){
            return;
        }
        System.out.print(arr[i]+" ");
        fun(i-1, arr);
    }
    public static void main(String[] args) {
        fun(arr.length-1, arr);
    }
}
