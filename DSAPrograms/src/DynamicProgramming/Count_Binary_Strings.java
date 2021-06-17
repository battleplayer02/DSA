/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Count_Binary_Strings {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int prev0 = 1;
        int prev1 = 1;
        int my0 = 0;
        int my1 = 0;
        for (int i = 2; i <= n; i++) {
            my0 = prev1;
            my1 = prev0 + prev1;
            prev0 = my0;
            prev1 = my1;
        }
        System.out.println(my0 + my1);
    }
}
