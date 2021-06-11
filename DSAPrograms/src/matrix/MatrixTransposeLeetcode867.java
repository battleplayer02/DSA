/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author Administrator
 */
public class MatrixTransposeLeetcode867 {

    public int[][] transpose(int[][] matrix) {
        int temp[][] = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][i] = matrix[i][j];
            }

        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
