/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurssion;

/**
 *
 * @author Administrator
 */
public class Power {
    public static int power(int a,int b){
        if(b==0){
            return 1;
        }
        return a*power(a, b-1);
    }
    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
}
