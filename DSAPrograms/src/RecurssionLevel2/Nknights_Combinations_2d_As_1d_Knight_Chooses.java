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
public class Nknights_Combinations_2d_As_1d_Knight_Chooses {

    static boolean isInside(int x, int y, int N) {
        if (x >= 0 && x <= N - 1 && y >= 0 && y <= N - 1) {
            return true;
        }
        return false;
    }

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        // write your code here
        int xMove[] = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        for (int k = 0; k < yMove.length; k++) {
            int x = i + xMove[k], y = i + yMove[k];
            if (isInside(x, y, chess.length)) {
                if (chess[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}
