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
public class Leetcode_40 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, 0, candidates, "", target, 0);
        return ans;
    }

    public static void helper(List<List<Integer>> ans, int idx, int nums[], String asf, int target, int ssf) {
        if (idx == nums.length) {
            if (ssf == target) {
                String[] arr = asf.split(" ");
                ArrayList<Integer> a = new ArrayList<>();
                for (String arr1 : arr) {
                    if (arr1.length() != 0) {
                        a.add(Integer.parseInt(arr1));
                    }
                }
                ans.add(a);
            }
            return;
        }
        helper(ans, idx + 1, nums, asf + " " + nums[idx], target, ssf + nums[idx]);
        helper(ans, idx + 1, nums, asf, target, ssf);
    }

    public static void main(String[] args) {
        Leetcode_40 obj = new Leetcode_40();
        System.out.println(obj.combinationSum(new int[]{1,2, 3, 6, 7}, 3));
    }
}
