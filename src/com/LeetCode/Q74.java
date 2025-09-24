// You are given an m x n integer matrix matrix with the following two properties:
// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the
// previous row.
// Given an integer target, return true if target is in matrix or false
// otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

// Example 2:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104

public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        if (matrix[0][0] > target || matrix[row - 1][col - 1] < target)
            return false;
        if (row == 1 && col == 1)
            return matrix[0][0] == target;
        if (row == 1)
            return binarySearch(matrix[0], 0, col - 1, target);

        int i = 0;
        while (i < row && matrix[i][col - 1] < target) {
            i++;
        }
        if (i == row)
            return false;
        return binarySearch(matrix[i], 0, col - 1, target);
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}