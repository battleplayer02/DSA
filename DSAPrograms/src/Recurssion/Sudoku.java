/*
 1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
 2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
 Rule 1 -> Digits from 1-9 must occur exactly once in each row.
 Rule 2 -> Digits from 1-9 must occur exactly once in each column.
 Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

 Input

 3 0 6 5 0 8 4 0 0
 5 2 0 0 0 0 0 0 0
 0 8 7 0 0 0 0 3 1
 0 0 3 0 1 0 0 8 0
 9 0 0 8 6 3 0 0 5
 0 5 0 0 9 0 6 0 0
 1 3 0 0 0 0 2 5 0
 0 0 0 0 0 0 0 7 4
 0 0 5 2 0 6 3 0 0
    
 Output

 3 1 6 5 7 8 4 9 2 
 5 2 9 1 3 4 7 6 8 
 4 8 7 6 2 9 5 3 1 
 2 6 3 4 1 5 9 8 7 
 9 7 4 8 6 3 1 2 5 
 8 5 1 7 9 2 6 4 3 
 1 3 8 9 4 7 2 5 6 
 6 9 2 3 5 1 8 7 4 
 7 4 5 2 8 6 3 1 9 
 */
package Recurssion;

import java.util.Scanner;

public class Sudoku {

    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }

    private static void solveSudoku(int[][] board, int i, int j) {
        if(i==board.length ){
            display(board);
            return;
        }
        int ni = 0;
        int nj = 0;
        if(j==board[0].length-1){
            ni = i+1;
            nj = 0;
        }
        else{
            ni = i;
            nj = j+1;
        }
        if(board[i][j] != 0){
            solveSudoku(board, ni, nj);
        }
        else
        {
            for(int po=1;po<=9;po++)
            {
                if(isValid(board,i,j,po)){
                    board[i][j] = po;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
        
    }
    
    public static boolean isValid(int[][] board,int x,int y,int val) {
        for (int j = 0; j < board[0].length; j++) {
            if(board[x][j] == val){
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][y] == val){
                return false;
            }
        }
        x = (x/3) * 3;
        y = (y/3) * 3;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        
        
        return true;
    }
}
