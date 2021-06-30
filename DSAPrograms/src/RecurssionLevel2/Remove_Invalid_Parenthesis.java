/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecurssionLevel2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class Remove_Invalid_Parenthesis {

    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        if (minRemoval == 0) {
            if (getMin(str) == 0 && !ans.contains(str)) {
                System.out.println(str);
                ans.add(str);
            }
            return;
        }
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            sb.deleteCharAt(i);
            String ros = sb.toString();
            solution(ros, minRemoval, ans);
            sb.insert(i, str.charAt(i));
        }
    }

    public static int getMin(String str) {
        //write your code here
        Stack<Character> st = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0) {
                    st.push(ch);
                } else if (st.peek() == ')') {
                    st.push(ch);
                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str, getMin(str), new HashSet<>());
    }

}
