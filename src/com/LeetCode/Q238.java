// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

// Constraints:
// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

public class Q238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = product;
            product *= nums[i];
        }
        product = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            right[i] = product;
            product *= nums[i];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : productExceptSelf(new int[] { 1, 2, 3, 4 })) {
            System.out.print(i + " ");
        }
    }
}