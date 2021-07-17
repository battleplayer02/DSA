/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

/**
 *
 * @author Administrator
 */
import java.util.*;

public class Max_Score {

    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }
        int scoreno = solution(words, farr, score, idx + 1); // no not include

        // include the word
        int scoreIdxth = 0;
        String wordIdxth = words[idx];
        boolean flag = true;
        for (int i = 0; i < wordIdxth.length(); i++) {
            char c = wordIdxth.charAt(i);
            if (farr[c - 'a'] == 0) {
                flag = false;
            }
            farr[c - 'a']--;
            scoreIdxth += score[c - 'a'];
        }
        int scoreyes = 0;
        if (flag) {
            scoreyes = scoreIdxth + solution(words, farr, score, idx + 1);
        }
        for (int i = 0; i < wordIdxth.length(); i++) {
            farr[wordIdxth.charAt(i) - 'a']++;
        }
        return Math.max(scoreno, scoreyes);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            scn.close();
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));
        scn.close();
    }
}
