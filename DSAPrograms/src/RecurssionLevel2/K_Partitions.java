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

public class K_Partitions {

    static int c = 0;

    public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
        if (i > n) {
            if (rssf == k) {
                System.out.print(c + 1 + ". ");
                for (ArrayList<Integer> an : ans) {
                    System.out.print(an + " ");
                }
                c++;
                System.out.println("");
            }
            return;
        }
        for (int j = 0; j < k; j++) {
            ArrayList<Integer> set = ans.get(j);
            if (set.size() != 0) {
                set.add(i);
                solution(i + 1, n, k, rssf, ans);
                set.remove(set.size() - 1);
            } else {
                set.add(i);
                solution(i + 1, n, k, rssf + 1, ans);
                set.remove(set.size() - 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(1, n, k, 0, ans);

    }
}
