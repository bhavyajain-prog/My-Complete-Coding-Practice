// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

// Example 1:
// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

// Example 2:
// Input: nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

import datastructures.TreeNode;

public class Q108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int high, int low) {
        if (high >= low) {
            return null;
        }
        int mid = (high + low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, high, mid);
        root.right = construct(nums, mid + 1, low);
        return root;
    }
}
