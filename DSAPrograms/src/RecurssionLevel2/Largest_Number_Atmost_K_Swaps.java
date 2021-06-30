package RecurssionLevel2;

import java.util.Scanner;

public class Largest_Number_Atmost_K_Swaps {

    static String max;

    public static void findMaximum(String str, int k) {
        //write your code here
        max = Math.max(Integer.parseInt(max), Integer.parseInt(str)) + "";
        if (k == 0) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    String swap = swap(str, i, j);
                    findMaximum(swap, k - 1);
                }
            }
        }
    }

    private static String swap(String str, int i, int j) {
        StringBuilder s = new StringBuilder(str);
        char ith = s.charAt(i);
        char jth = s.charAt(j);
        s.setCharAt(i, jth);
        s.setCharAt(j, ith);
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        findMaximum(str, k);
        System.out.println(max);
    }

}
