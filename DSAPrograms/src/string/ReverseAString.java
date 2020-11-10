/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string;

/**
 *
 * @author Administrator
 */
public class ReverseAString {

    public static void main(String[] args) {
        System.out.println(rev("1234"));
    }

    private static String rev(String string) {
        String temp = "";
        for (int i = string.length()-1; i >= 0; i--) {
               temp+=string.charAt(i);
        }
        return temp;
    }
}
