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
public class PrintIncDec {
    public static int n =5;

    public static void printID(int n){
        if (n==0) {
            return;
        }
        System.out.println(n);
        printID(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        printID(n);
    } 
}
