/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

import java.util.*;

/**
 *
 * @author Administrator
 */
public class Cryptarithmetic {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();
        
        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }
        
        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }
        
        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
    }
    
    public static int makeNumber(HashMap<Character, Integer> charIntMap, String s) {
        String num = "";
        for (char ch : s.toCharArray()) {
            num += charIntMap.get(ch);
        }
        return Integer.parseInt(num);
    }
    
    public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, String s1, String s2, String s3) {
        // write your code here
        if (idx == unique.length()) {
            int n1 = makeNumber(charIntMap, s1);
            int n2 = makeNumber(charIntMap, s2);
            int n3 = makeNumber(charIntMap, s3);
            if (n1 + n2 == n3) {
                for (char ch = 'a'; ch < 'z'; ch++) {
                    if (charIntMap.containsKey(ch)) {
                        System.out.print(ch + "-" + charIntMap.get(ch));
                    }
                }
                System.out.println("");
            }
            return;
        }
        for (int digit = 0; digit < 10; digit++) {
            if (!usedNumbers[digit]) {
                usedNumbers[digit] = true;
                charIntMap.put(unique.charAt(idx), digit);
                solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
                charIntMap.put(unique.charAt(idx), -1);
                usedNumbers[digit] = false;
            }
        }
    }
}
