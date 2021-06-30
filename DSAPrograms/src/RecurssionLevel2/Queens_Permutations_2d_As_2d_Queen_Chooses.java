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
public class Queens_Permutations_2d_As_2d_Queen_Chooses {

    public static void queensPermutations(int qpsf, int tq, int[][] chess) {
        // write your code here
        if (qpsf == tq) {
            for (int[] ches : chess) {
                for (int che : ches) {
                    System.out.print(che != 0 ? "q" + che + "\t" : "-\t");
                }
                System.out.println("");
            }
            System.out.println("");
            return;
        }
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] == 0) {
                    chess[i][j] = (qpsf + 1);
                    queensPermutations(qpsf + 1, tq, chess);
                    chess[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        queensPermutations(0, n, chess);
    }
}
