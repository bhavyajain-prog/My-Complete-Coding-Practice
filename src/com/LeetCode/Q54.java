// Given an m x n matrix, return all elements of the matrix in spiral order.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        char dir = 'r';
        int i = 0, j = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        while (result.size() < m * n) {
            result.add(matrix[i][j]);
            visited[i][j] = true;
            if (dir == 'r') {
                if (j + 1 < n && !visited[i][j + 1]) {
                    j++;
                } else {
                    dir = 'd';
                    i++;
                }
            } else if (dir == 'd') {
                if (i + 1 < m && !visited[i + 1][j]) {
                    i++;
                } else {
                    dir = 'l';
                    j--;
                }
            } else if (dir == 'l') {
                if (j - 1 >= 0 && !visited[i][j - 1]) {
                    j--;
                } else {
                    dir = 'u';
                    i--;
                }
            } else if (dir == 'u') {
                if (i - 1 >= 0 && !visited[i - 1][j]) {
                    i--;
                } else {
                    dir = 'r';
                    j++;
                }
            }
        }
        return result;
    }
}
