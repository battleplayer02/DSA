/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class MergeIntervals_Leetcode_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.size() == 0) {
                list.add(interval);
            } else {
                int lastIntervalInList[] = list.get(list.size() - 1);
                if (interval[0] < lastIntervalInList[1]) {
                    lastIntervalInList[1] = Math.max(lastIntervalInList[1], interval[1]);
                } else {
                    list.add(interval);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

    }
}
