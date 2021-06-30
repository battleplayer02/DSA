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
public class Josephus_Problem {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        System.out.println(solution(n, k));
    }

    private static int solution(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (solution(n - 1, k) + k) % n;
    }
}
