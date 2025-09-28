// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
// frequency of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

// Example 2:
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]

// Example 3:
// Input: candidates = [2], target = 1
// Output: []

import java.util.ArrayList;
import java.util.List;

public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return result;
        result = helper(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    private List<List<Integer>> helper(List<List<Integer>> res, List<Integer> list, int[] nums, int target,
            int sum, int i) {
        if (i < nums.length) {
            sum += nums[i];
            list.add(nums[i]);
            if (sum == target) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(list);
                res.add(temp);
            }
            if (sum > target) {
                list.remove(list.size() - 1);
                sum -= nums[i];
                res = helper(res, list, nums, target, sum, i + 1);
            } else {
                res = helper(res, list, nums, target, sum, i);
                list.remove(list.size() - 1);
                sum -= nums[i];
                res = helper(res, list, nums, target, sum, i + 1);
            }
        }
        return res;
    }
}