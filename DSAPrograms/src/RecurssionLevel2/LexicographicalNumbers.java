/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class LexicographicalNumbers {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 1; i < 10; i++) {
            printNumbers(i, n);
        }
    }
    static int x = 0;

    public static void printNumbers(int n, int ln) {
        if (n <= ln) {
            System.out.println(n + " -- " + ++x);
            for (int i = 0; i < 10; i++) {
                printNumbers(n * 10 + i, ln);
            }
        }
        return;
    }
}
