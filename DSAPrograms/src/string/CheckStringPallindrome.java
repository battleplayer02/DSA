package string;

import java.util.Scanner;

public class CheckStringPallindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.next();
        int start = 0;
        int end = s1.length()-1;
        int flag = 0;
        while(start<=end){
            if(s1.charAt(start) != s1.charAt(end)){
                flag = 1;
                break;
            }
            start++;
            end--;
        }
        if(flag == 1){
            System.out.println("Not Pallindrome");
        }else{
            System.out.println("Is a Pallindrome");
        }
        
    }
}
