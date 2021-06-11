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
public class Insert_Intervals_Leetcode_57 {

    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newIntrevals[][] = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newIntrevals[i] = intervals[i];
        }
        newIntrevals[intervals.length] = newInterval;
        return merge(newIntrevals);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.size() == 0) {
                list.add(interval);
            } else {
                int lastIntervalInList[] = list.get(list.size() - 1);
                if (interval[0] <= lastIntervalInList[1]) {
                    lastIntervalInList[1] = Math.max(lastIntervalInList[1], interval[1]);
                } else {
                    list.add(interval);
                }
            }
        }
        int returnarr[][] = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            returnarr[i] = list.get(i);
        }
        return returnarr;
    }
    
    
    
}
 