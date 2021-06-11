package DynamicProgramming;

import java.util.Scanner;

public class FactorialOfLargeNumber {
    
    public static int fact(int n, int[] arr){
        if(arr[n]!=0){
            return arr[n];
        }
        if(n == 0){
            return 1;
        }
        int f = n*fact(n-1, arr);
        arr[n] = f;
        return f;
    }
    
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            while(t-->0){
                int n = s.nextInt();
                int[] arr = new int [n+1];
                System.out.println(fact(n,arr));
            }
        }
}
