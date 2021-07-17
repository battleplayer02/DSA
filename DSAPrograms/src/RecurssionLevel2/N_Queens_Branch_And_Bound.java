package RecurssionLevel2;

import java.util.*;

public class N_Queens_Branch_And_Bound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] board = new int[N][N];
        boolean cols[] = new boolean[N];
        boolean ndiag[] = new boolean[2 * N - 1];
        boolean rdiag[] = new boolean[2 * N - 1];
        solver(board, 0, cols, ndiag, rdiag, "");
    }

    public static void solver(int[][] board, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag, String path) {
        if (row == board.length) {
            System.out.println(path + ".");
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (!cols[col] && !ndiag[row + col] && !rdiag[row - col + board.length - 1]) {
                cols[col] = true;
                ndiag[row + col] = true;
                rdiag[row - col + board.length - 1] = true;
                solver(board, row + 1, cols, ndiag, rdiag, path + row + "-" + col + ",");
                cols[col] = false;
                ndiag[row + col] = false;
                rdiag[row - col + board.length - 1] = false;
            }
        }
    }
}
