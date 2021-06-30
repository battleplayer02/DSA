/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Crossword {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);

    }

    public static void solution(char[][] arr, String[] words, int vidx) {
        if (vidx == words.length) {
            print(arr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String word = words[vidx];
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (canPlaceVertical(arr, word, i, j) == true) {
                        placeVertical(arr, word, i, j);
                        //call
                        solution(arr, words, vidx + 1);
                        unplaceVertical(arr, word, i, j);
                    }

                    if (canPlaceHorizontal(arr, word, i, j) == true) {
                        placeHorizontal(arr, word, i, j);
                        //call
                        solution(arr, words, vidx + 1);
                        unplaceHorizontal(arr, word, i, j);
                    }
                }
            }
        }
    }

    public static boolean canPlaceVertical(char[][] arr, String word, int r, int c) {
        int i = 0;
        for (; i < word.length(); i++) {
            if (r + i >= 10) {
                return false;
            }
            if (arr[r + i][c] == '-' || arr[r + i][c] == word.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }

        if (r + i == 10 || arr[r + i][c] == '+') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean canPlaceHorizontal(char[][] arr, String word, int r, int c) {
        int i = 0;
        for (; i < word.length(); i++) {
            if (c + i >= 10) {
                return false;
            }
            if (arr[r][c + i] == '-' || arr[r][c + i] == word.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        if (c + i == 10 || arr[r][c + i] == '+') {
            return true;
        } else {
            return false;
        }
    }

    public static void placeVertical(char[][] arr, String word, int r, int c) {
        for (int i = 0; i < word.length(); i++) {
            arr[r + i][c] = word.charAt(i);
        }
    }

    public static void unplaceVertical(char[][] arr, String word, int r, int c) {
        for (int i = 0; i < word.length(); i++) {
            if (r >= 0 || c + 1 < 10 || c >= 0 || r + 1 < 10 || !Character.isAlphabetic(arr[r][c + 1]) || !Character.isAlphabetic(arr[r][c + 1])) {
                arr[r + i][c] = '-';
            }
        }
    }

    public static void placeHorizontal(char[][] arr, String word, int r, int c) {
        for (int i = 0; i < word.length(); i++) {

            arr[r][c + i] = word.charAt(i);
        }
    }

    public static void unplaceHorizontal(char[][] arr, String word, int r, int c) {
        for (int i = 0; i < word.length(); i++) {
            if (r >= 0 || c + 1 < 10 || c >= 0 || r + 1 < 10 || !Character.isAlphabetic(arr[r][c + 1]) || !Character.isAlphabetic(arr[r][c + 1])) {
                arr[r][c + i] = '-';
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j] + "");
            }
            System.out.println();
        }

    }
}
