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
public class Arrange_Buildings {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ob = 1;
        int os = 1;
        for (int i = 2; i <= n; i++) {
            int nb = os;
            int ns = ob + os;
            ob = nb;
            os = ns;
        }
        int total = (ob + os);
        total*=total;
        System.out.println(total);
    }
}
