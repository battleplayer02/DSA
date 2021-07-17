package RecurssionLevel2;

import java.util.*;

public class GoldMine2 {

    static int max = 0;

    public static void getMaxGold(int[][] arr) {
        // write your code here
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!visited[i][j] && arr[i][j] != 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    travelAndSolve(arr, i, j, visited, list);
                    int sum = 0;

                    for (int k = 0; k < list.size(); k++) {
                        sum += list.get(k);
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
    }

    public static void travelAndSolve(int[][] arr, int row, int col, boolean[][] visited, ArrayList<Integer> list) {
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[row].length || arr[row][col] == 0
                || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        list.add(arr[row][col]);
        // north call
        travelAndSolve(arr, row - 1, col, visited, list);
        // south call
        travelAndSolve(arr, row + 1, col, visited, list);
        // east call
        travelAndSolve(arr, row, col + 1, visited, list);
        // west call
        travelAndSolve(arr, row, col - 1, visited, list);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        getMaxGold(arr);
        System.out.println(max);
        scn.close();
    }

}
