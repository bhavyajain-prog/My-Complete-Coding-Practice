// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

// Example 1:
// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]

// Example 2:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Constraints:
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) {
            List<Integer> newList = new ArrayList<>();
            for (int i : permutation) {
                newList.add(nums[i]);
            }
            if (!result.contains(newList))
                result.add(new ArrayList<>(newList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(i))
                continue;

            permutation.add(i);
            backtrack(result, permutation, nums);
            permutation.remove(permutation.size() - 1);

            while (i + 1 < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        List<List<Integer>> res = permuteUnique(nums);
        System.out.println(res);
    }
}
