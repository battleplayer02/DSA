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
public class Queens_Permutations_2d_As_2d_Box_Chooses {

    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        // write your code here
        if (row == tq) {
            if (qpsf == tq) {
                System.out.print(asf);
                System.out.println("");
            }
            return;
        }
        if (col == tq - 1) {
            row++;
            col = 0;
            for (int i = 0; i < queens.length; i++) {
                if (!queens[i]) {
                    queens[i] = !queens[i];
                    queensPermutations(qpsf + 1, tq, row, col, asf + "q" + (i + 1) + "\n", queens);
                    queens[i] = !queens[i];
                }
            }
            queensPermutations(qpsf, tq, row, col, asf + "-\n", queens);
        } else {
            col++;
            for (int i = 0; i < queens.length; i++) {
                if (!queens[i]) {
                    queens[i] = !queens[i];
                    queensPermutations(qpsf + 1, tq, row, col, asf + "q" + (i + 1) + "\t", queens);
                    queens[i] = !queens[i];
                }
            }
            queensPermutations(qpsf, tq, row, col, asf + "-\t", queens);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
