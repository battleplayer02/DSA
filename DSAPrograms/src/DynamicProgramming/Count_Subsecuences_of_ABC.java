/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Count_Subsecuences_of_ABC {

    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        int countAplus = 0, countAplusBplus = 0, countAplusBplusCplus = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case 'a':
                    countAplus = (2 * countAplus) + 1;
                    break;
                case 'b':
                    countAplusBplus = (2 * countAplusBplus) + countAplus;
                    break;
                case 'c':
                    countAplusBplusCplus = (2 * countAplusBplusCplus) + countAplusBplus;
                    break;
            }
        }
        System.out.println(countAplusBplusCplus);
    }
}
