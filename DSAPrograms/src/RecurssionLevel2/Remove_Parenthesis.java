package RecurssionLevel2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Remove_Parenthesis {

    public static void solution(String str, int minRemoval, HashSet<String> ans) {
        if (minRemoval == 0) {
            if (getMin(str) == 0) {
                if (!ans.contains(str)) {
                    ans.add(str);
                    System.out.println(str);
                }
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            solution(left + right, minRemoval - 1, ans);
        }
    }

    public static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                if (st.isEmpty()) {
                    st.push(c);
                } else if (st.peek() == ')') {
                    st.push(c);
                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();
    }

    public static boolean isValid(String str) {
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int mr = getMin(str);
        solution(str, mr, new HashSet<>());
        scn.close();
    }
}