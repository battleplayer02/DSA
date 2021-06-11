package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpiralTraversal {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(br.readLine());
         }
      }
      int minr = 0;
      int minc = 0;
      int maxr = arr.length-1;
      int maxc = arr[0].length-1;
      int cnt = 0;
      int tne  = n * m;
      while(cnt < tne){
         for(int i = minr; i <= maxr && cnt < tne; i++){
            System.out.println(arr[i][minc]);
            cnt++;
         }
         minc++;

         for(int j = minc; j <= maxc && cnt < tne; j++){
            System.out.println(arr[maxr][j]);
            cnt++;
         }
         maxr--;

         for(int i = maxr; i >= minr && cnt < tne; i--){
            System.out.println(arr[i][maxc]);
            cnt++;
         }
         maxc--;

         for(int j = maxc; j >= minc && cnt < tne; j--){
            System.out.println(arr[minr][j]);
            cnt++;
         }
         minr++;

      }
      
      
    }
}
