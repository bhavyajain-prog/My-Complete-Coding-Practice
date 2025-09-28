//Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//The overall run time complexity should be O(log (m+n)).

//Example 1:
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.

//Example 2:
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

public class Q4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		if (n > m)
			return findMedianSortedArrays(nums2, nums1);

		int start = 0;
		int end = n;
		int midinmergedarr = (n + m + 1) / 2;

		while (start <= end) {
			int mid = (start + end) / 2;
			int leftnums1 = mid;
			int leftnums2 = midinmergedarr - mid;

			int min1 = (leftnums1 > 0) ? nums1[leftnums1 - 1] : Integer.MIN_VALUE;
			int min2 = (leftnums2 > 0) ? nums2[leftnums2 - 1] : Integer.MIN_VALUE;
			int max1 = (leftnums1 < n) ? nums1[leftnums1] : Integer.MAX_VALUE;
			int max2 = (leftnums2 < m) ? nums2[leftnums2] : Integer.MAX_VALUE;

			if (min1 <= max2 && min2 <= max1) {
				if ((m + n) % 2 == 0)
					return (Math.max(min1, min2) + Math.min(max1, max2)) / 2.0;
				return Math.max(min1, min2);
			} else if (min1 > max2) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return 0.0;

	}
}
