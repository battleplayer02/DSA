/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class Queen_2D_As_1D {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here\
        if (qpsf == tq) {
            for (boolean[] ches : chess) {
                for (boolean che : ches) {
                    if (che) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("");
            return;
        }
        for (int i = lcno + 1; i < tq * tq; i++) {
            int r = i / tq;
            int c = i % tq;
            chess[r][c] = true;
            queensCombinations(qpsf + 1, tq, chess, i);
            chess[r][c] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
