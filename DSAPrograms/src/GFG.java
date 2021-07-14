/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int a = Integer.parseInt(input_line[0]);
            int b = Integer.parseInt(input_line[1]);
            int x = Integer.parseInt(input_line[2]);
            int y = Integer.parseInt(input_line[3]);

            Sol ob = new Sol();
            boolean ans = ob.checkmate(a, b, x, y); 
            System.out.println(ans?1:0);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Sol 
{ 
    public int chess[][];
    public boolean isKingSafe(int x,int y){
        //vertical
        for(int row = 0;row<chess.length;row++){
            if(chess[row][y] == 1){
                return false;
            }
        }
        
        //horizontal
        for(int col = 0;col<chess.length;col++){
            if(chess[x][col] == 1){
                return false;
            }
        }
        
        
        for(int i = x,j=y;i>=0 && j>=0;i--,j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        for(int i = x,j = y;i<chess.length && j>=0;i++,j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        
        for(int i = x,j = y;i<chess.length && j<chess.length ;i++,j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i = x,j = y;i>=0 && j<chess.length ;i--,j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        return true;
        
    }
    boolean checkmate(int a, int b, int x, int y) 
    { 
        // code here
        chess = new int[8][8];
        //king
        // chess[a][b] = 1;
        
        //queen
        chess[x-1][y-1] = 1;
        if(isKingSafe(a,b)){
            return false;
        }else{
            return true;
        }
    }
} 