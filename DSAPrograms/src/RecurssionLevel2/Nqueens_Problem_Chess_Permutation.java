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
cxc
    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        for (int i = 0, j = col; i < chess.length; i++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row, j = 0; j < chess[0].length; j++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i < chess.length && j < chess[0].length; i++, j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row + 1, j = col + 1; i < chess.length && j < chess[0].length; i--, j--) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row + 1, j = col - 1; i < chess.length && j >= 0; i++) {
            if (chess[i][j] > 0) {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i <= 0 && j >= 0; i++) {
            if (chess[i][j] > 0) {
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
