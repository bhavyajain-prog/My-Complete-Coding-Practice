// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

// Example 3:
// Input: nums = [1], target = 0
// Output: -1

public class Q33 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }
        if (nums[0] == target)
            return 0;
        if (target > nums[0]) {
            int i = 1;
            while (nums[i] > nums[i - 1]) {
                if (nums[i] == target)
                    return i;
                i++;
                if (i >= nums.length)
                    break;
            }
        } else {
            int i = nums.length - 1;
            while (nums[i] > nums[i - 1]) {
                if (nums[i] == target)
                    return i;
                i--;
                if (i <= 0)
                    break;
            }
            if (nums[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 1, 3 }, 0));
    }
}