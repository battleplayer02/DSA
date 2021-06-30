import java.util.AbstractList;
import java.util.ArrayList;
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
public class Leetcode43 {

    static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int init[] = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                init[i] = 55;
            }
            permutation(init, 0, nums, ans);
            return ans;
        }

        private void permutation(int[] asf, int idx, int[] nums, List<List<Integer>> ans) {
            if (idx == nums.length) {
                ArrayList<Integer> barr = new ArrayList<>();
                for (int a : asf) {
                    barr.add(a);
                }
                ans.add(barr);
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (asf[i] == 55) {
                    asf[i] = nums[idx];
                    permutation(asf, idx + 1, nums, ans);
                    asf[i] = 55;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permute(new int[]{1, 2, 3}));
    }
}
