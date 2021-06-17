/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Words_K_Selection_1 {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

//        combination1(0, ustr, 0, k, "");
//        generateWords(k, 0, new Character[k], 0, ustr);
        generateWords2(0, ustr, 0, "", new HashSet<Character>(), k);
    }

    public static void combination1(int i, String ustr, int ssf, int ts, String asf) {
        if (i == ustr.length()) {
            if (ts == ssf) {
                System.out.println(asf);
            }
            return;
        }
        char ch = ustr.charAt(i);
        combination1(i + 1, ustr, ssf + 1, ts, asf + ch);
        combination1(i + 1, ustr, ssf, ts, asf);
    }

    public static void combination2(int lb, String ustr, int ssf, int ts, String asf) {
        if (ssf == ts) {
            System.out.println(asf);
            return;
        }
        for (int i = lb + 1; i < ustr.length(); i++) {
            combination2(i, ustr, ssf + 1, ts, asf + ustr.charAt(i));
        }
    }

    public static void generateWords(int totalPlaces, int placesFilledSofar, Character spots[], int idx, String ustr) {
        if (idx == ustr.length()) {
            if (placesFilledSofar == totalPlaces) {
                for (Character spot : spots) {
                    System.out.print(spot);
                }
                System.out.println();
            }
            return;
        }
        char ch = ustr.charAt(idx);
        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                generateWords(totalPlaces, placesFilledSofar + 1, spots, idx + 1, ustr);
                spots[i] = null;
            }
        }
        generateWords(totalPlaces, placesFilledSofar, spots, idx + 1, ustr);
    }

    public static void generateWords2(int boxno, String ustr, int ssf, String asf, HashSet<Character> used, int totBoxes) {
        if (boxno == totBoxes) {
            if (ssf == totBoxes) {
                System.out.println(asf);
            }
            return;
        }
//        generateWords2(boxno + 1, ustr, ssf, asf, used, totBoxes);
        for (char ch : ustr.toCharArray()) {
            if (!used.contains(ch)) {
                used.add(ch);
                generateWords2(boxno+1, ustr, ssf + 1, asf + ch, used, totBoxes);
                used.remove(ch);
            }
        }
    }
}
