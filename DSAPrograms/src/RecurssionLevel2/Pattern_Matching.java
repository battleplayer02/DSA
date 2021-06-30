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
public class Pattern_Matching {

    public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {
        //write your code here

        if (pattern.equals("")) {
            if (str.equals("")) {
                System.out.println(map);
            }
            return;
        }

        char ch = pattern.charAt(0);
        pattern = pattern.substring(1);

        if (map.containsKey(ch)) {
            String prevMappingString = map.get(ch);
            if (str.length() >= prevMappingString.length()) {
                String leftPart = str.substring(0, prevMappingString.length());
                if (leftPart.equals(prevMappingString)) {
                    String rightPart = str.substring(prevMappingString.length());
                    solution(rightPart, pattern, map, op);
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String leftPart = str.substring(0, i + 1);
                String rightPart = str.substring(i + 1);
                map.put(ch, leftPart);
                solution(rightPart, pattern, map, op);
                map.remove(ch);
            }
        }
    }
    static String pattern;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        pattern = scn.next();
        HashMap<Character, String> map = new HashMap<Character, String>() {

            @Override
            public String toString() {
                HashSet<Character> used = new HashSet<>();
                String print = "";
                for (Character key : pattern.toCharArray()) {
                    if (!used.contains(key)) {
                        print += key + " -> " + get(key) + ", ";
                        used.add(key);
                    }
                }
                print += ".";
                return print; //To change body of generated methods, choose Tools | Templates.
            }
        };
        solution(str, pattern, map, pattern);
    }
}
