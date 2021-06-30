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
public class Nqueens_Problem_Chess_Permutation {

    public static boolean IsQueenSafe(int[][] chess, int r, int c) {
        // write your code here
        for (int row = 0, col = 0; row < chess.length && col < chess.length; row++, col++) {
            if (chess[row][c] != 0) {
                return false;
            }
            if (chess[r][col] != 0) {
                return false;
            }
        }

        for (int row = r - 1, col = c - 1; row >= 0 && col >= 0; row--, col--) {
            if (chess[row][col] != 0) {
                return false;
            }
        }

        for (int row = r - 1, col = c + 1; row >= 0 && col < chess.length; row--, col++) {
            if (chess[row][col] != 0) {
                return false;
            }
        }

        for (int row = r + 1, col = c + 1; row < chess.length && col < chess.length; row++, col++) {
            if (chess[row][col] != 0) {
                return false;
            }
        }

        for (int row = r + 1, col = c - 1; row < chess.length && col >= 0; row++, col--) {
            if (chess[row][col] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        if (qpsf == tq) {
            for (int[] ches : chess) {
                for (int che : ches) {
                    System.out.print(
                            che == 0 ? "-\t" : "q" + che + "\t"
                    );
                }
                System.out.println("");
            }
            System.out.println("");
        }
        for (int i = 0; i < tq * tq; i++) {
            int r = i / tq;
            int c = i % tq;
            if (chess[r][c] == 0 && IsQueenSafe(chess, r, c)) {
                chess[r][c] = qpsf + 1;
                nqueens(qpsf + 1, tq, chess);
                chess[r][c] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
