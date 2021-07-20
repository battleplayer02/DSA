package RecurssionLevel2;

import java.util.Scanner;

public class All_Palindromic_Partitions {

    public static void solution(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        // write you code here
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            String suffix = str.substring(i + 1);
            if (isPalindrome(prefix)) {
                solution(suffix, asf + "(" + prefix + ") ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
        scn.close();
    }

    // is a palindrome
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}