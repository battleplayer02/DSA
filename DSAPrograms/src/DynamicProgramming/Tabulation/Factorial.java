/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming.Tabulation;

import static DynamicProgramming.Memoization.FactorialOfLargeNumber.fact;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] arr = new int[n + 1];
            
            for (int i = 0; i <= n; i++) {
                if(i==0){
                    arr[i] = 1;
                }
                else{
                    arr[i] = i*arr[i-1];
                }
            }
            System.out.println(arr[n]);
        }
    }

}
