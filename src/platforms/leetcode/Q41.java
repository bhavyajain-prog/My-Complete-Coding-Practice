// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

// Example 1:
// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.

// Example 2:
// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.

// Example 3:
// Input: nums = [7,8,9,11,12]
// Output: 1
// Explanation: The smallest positive integer 1 is missing.

// Constraints:
// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1

public class Q41 {
    public int firstMissingPositive(int[] nums) {
        boolean contains1 = false;
        for (int x : nums) {
            if (x == 1) {
                contains1 = true;
                break;
            }
        }
        if (!contains1)
            return 1;
        int n = nums.length;
        if (n == 1)
            return 2;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0)
                nums[num - 1] *= -1;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Q41 solution = new Q41();

        int[] nums1 = { 1, 2, 0 };
        int result1 = solution.firstMissingPositive(nums1);
        System.out.println("Result 1: " + result1);

        int[] nums2 = { 3, 4, -1, 1 };
        int result2 = solution.firstMissingPositive(nums2);
        System.out.println("Result 2: " + result2);

        int[] nums3 = { 7, 8, 9, 11, 12 };
        int result3 = solution.firstMissingPositive(nums3);
        System.out.println("Result 3: " + result3);

        int[] nums4 = { 2, 1 };
        int result4 = solution.firstMissingPositive(nums4);
        System.out.println("Result 4: " + result4);
    }
}
