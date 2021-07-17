package pep_test;

import java.util.*;

public class q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // input str
        String str = in.next();
        int cnt = 0;
        // PRINT ALL substrings
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String s = str.substring(i, j + 1);
                if (isValid(s)) {
                    // System.out.println(s);
                    cnt++;
                }
            }
            // System.out.println();
        }
        System.out.println(cnt);
    }

    // is valid -> having same first and last character
    public static boolean isValid(String str) {
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return true;
        }
        return false;
    }
}