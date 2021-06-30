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
public class All_palindromic_permutations {

    public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if (cs == ts) {
            System.out.print(asf);
            if (oddc != null) {
                System.out.print(oddc);
            }
            System.out.println(new StringBuilder(asf).reverse().toString());
            return;
        }
        for (Character ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq != 0) {
                fmap.put(ch, freq - 1);
                generatepw(cs + 1, ts, fmap, oddc, asf + ch);
                fmap.put(ch, freq);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }
        Character oddCharacter = null;
        int len = 0;
        for (Character ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq % 2 != 0) {
                if (oddCharacter != null) {
                    System.out.println(-1);
                    return;
                }
                oddCharacter = ch;
            }
            fmap.put(ch, freq / 2);
            len += freq / 2;
        }
        generatepw(0, len, fmap, oddCharacter, "");
    }

}
