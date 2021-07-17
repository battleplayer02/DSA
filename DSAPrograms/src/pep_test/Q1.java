package pep_test;

import java.util.*;

public class Q1 {

    static int ROW = 9;
    static int COL = 10;
    static int[][] matrix;

    // main method
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // input row column
        ROW = s.nextInt();
        COL = s.nextInt();
        // input matrix
        matrix = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        // output
        int aa = 0;
        for (int i = 0; i < ROW; i++) {
            int a = BFS(matrix, new Point(i, 0), new Point(ROW - 1, COL - 1));
            aa = Math.min(aa, a);
        }
        System.out.println(aa);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    };

    static class queueNode implements Comparable<queueNode> {
        Point pt;
        int dist;

        public queueNode(Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }

        // implements Comparable<queueNode>
        public int compareTo(queueNode qn) {
            return this.dist - qn.dist;
        }

    };

    static boolean isValid(int row, int col) {
        if (col - 1 >= 0) {
            if ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL))
                if (matrix[row][col - 1] == 0)
                    return false;
        }
        if (row - 1 >= 0) {
            if ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL))
                if (matrix[row - 1][col] == 0)
                    return false;
        }
        if (row + 1 < ROW) {
            if ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL))
                if (matrix[row + 1][col] == 0)
                    return false;
        }
        if (col + 1 < COL) {
            if ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL)) {
                if (matrix[row][col + 1] == 0)
                    return false;
            }
        }
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    static int rowNum[] = { -1, 0, 0, 1 };
    static int colNum[] = { 0, -1, 1, 0 };

    public static int BFS(int mat[][], Point src, Point dest) {
        if (mat[src.x][src.y] != 1 || mat[dest.x][dest.y] != 1)
            return 1000000;

        boolean[][] visited = new boolean[ROW][COL];

        visited[src.x][src.y] = true;

        // priority queue
        PriorityQueue<queueNode> q = new PriorityQueue<queueNode>();

        queueNode s = new queueNode(src, 0);
        q.add(s);

        while (!q.isEmpty()) {
            queueNode curr = q.remove();
            Point pt = curr.pt;

            if (pt.y == dest.y)
                return curr.dist;

            for (int i = 0; i < 4; i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                if (isValid(row, col) && mat[row][col] == 1 && !visited[row][col]) {
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode(new Point(row, col), curr.dist + 1);
                    q.add(Adjcell);
                }
            }
        }

        return -1;
    }
}
