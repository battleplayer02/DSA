import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class NewClass {

    class Solution {

        public boolean containsNearbyDuplicate(int[] nums, int k) {

            HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                ArrayList<Integer> arr = hm.get(nums[i]);
                if (arr != null) {
                    for (int j : arr) {
                        if (Math.abs(j - i) <= k) {
                            return true;
                        }
                    }
                    arr.add(i);
                    hm.put(nums[i], arr);
                } else {
                    ArrayList<Integer> a = new ArrayList();
                    a.add(i);
                    hm.put(nums[i], a);
                }
            }
            return false;
        }
    }
}
