package RecurssionLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Queens_Combinations_2d_As_2d_Box_Chooses {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }
        if (col == tq - 1) {
            col = 0;
            row++;
            queensCombinations(qpsf + 1, tq, row, col, asf + "q" + "\n");
            queensCombinations(qpsf, tq, row, col, asf + "-" + "\n");
        } else {
            col++;
            queensCombinations(qpsf + 1, tq, row, col, asf + "q");
            queensCombinations(qpsf, tq, row, col, asf + "-");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}
