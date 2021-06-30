/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class Words_K_Selection_3 {

    public static void wordKSelection(int idx, String asf, int k, String originalString, HashMap<Character, Integer> map) {

        if (k < 0) {
            return;
        }
        if (idx == originalString.length()) {
            if (k == asf.length()) {
                System.out.println(asf);
            }
            return;
        }
        char ch = originalString.charAt(idx);
        for (int i = map.get(ch); i >= 0; i--) {
            String callingString = "";
            for (int j = 0; j < i; j++) {
                callingString += ch;
            }
            wordKSelection(idx + 1, asf + callingString, k, originalString, map);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> unique = new HashMap<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.containsKey(ch) == false) {
                unique.put(ch, 1);
                ustr += ch;
            } else {
                unique.put(ch, unique.get(ch) + 1);
            }
        }
        wordKSelection(0, "", k, ustr, unique);
    }
}
