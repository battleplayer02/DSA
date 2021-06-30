import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class SmallestNumber_FromDigits {

    // function to find the smallest number
    static int[] freq = new int[10];

    static int smallest(int num) {
        // initialize frequency of each digit to Zero

        // count frequency of each digit in the number
        while (num > 0) {
            int d = num % 10; // extract last digit
            freq[d]++; // increment counting
            num = num / 10; //remove last digit
        }
        System.out.println(
                new ArrayList<Integer>() {
                    {
                        for (int j = 0; j < freq.length; j++) {
                            int g = freq[j];
                            add(g);
                        }
                    }
                });
        // Set the LEFTMOST digit to minimum expect 0
        int result = 0;
        for (int i = 1; i <= 9; i++) {
            if (freq[i] != 0) {
                result = i;
                freq[i]--;
                break;
            }
        }

        // arrange all remaining digits
        // in ascending order
        for (int i = 0; i <= 9; i++) {
            while (freq[i]-- != 0) {
                result = result * 10 + i;
            }
        }

        return result;
    }

    // Driver Program
    public static void main(String args[]) {
        int num = 570107;
        System.out.println(smallest(num));
    }
}
