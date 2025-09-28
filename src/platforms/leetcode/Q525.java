// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

// Example 1:
// Input: nums = [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

// Example 2:
// Input: nums = [0,1,0]
// Output: 2
// Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

// Constraints:
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.

import java.util.HashMap;
import java.util.Map;

public class Q525 {
    public int findMaxLength(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0] == 0 ? -1 : 1;
        for (int i = 0; i < nums.length - 1; i++) {
            prefix[i + 1] = prefix[i] + (nums[i + 1] == 0 ? -1 : 1);
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < prefix.length; i++) {
            if (map.containsKey(prefix[i])) {
                max = Math.max(max, i - map.get(prefix[i]));
            } else {
                map.put(prefix[i], i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q525 q = new Q525();
        int[] nums = { 0, 0, 1, 0, 0, 0, 1, 1 };
        System.out.println(q.findMaxLength(nums));
    }
}
