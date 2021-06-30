/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recurssion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Generate_all_balanced_parenthesis {

    class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> output_arr = new ArrayList();
            backtrack(output_arr, "", 0, 0, n);
            return output_arr;
        }

        public void backtrack(List<String> output_arr, String current_string, int open, int close, int max) {
            if (current_string.length() == max * 2) {
                output_arr.add(current_string);
                return;
            }
            if (open < max) {
                backtrack(output_arr, current_string + "(", open + 1, close, max);
            }
            if (close < open) {
                backtrack(output_arr, current_string + ")", open, close + 1, max);
            }
        }
    }
}
