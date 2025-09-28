// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

// Example 2:
// Input: n = 1
// Output: [["Q"]]

// Constraints:
// 1 <= n <= 9

import java.util.ArrayList;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[] board = new char[n];
        boolean[] cols = new boolean[n];
        boolean[] diagonals = new boolean[2 * n - 1];
        boolean[] antiDiagonals = new boolean[2 * n - 1];

        helper(0, n, result, board, cols, diagonals, antiDiagonals);
        return result;
    }

    private void helper(int row, int n, List<List<String>> result, char[] board,
            boolean[] cols, boolean[] diagonals, boolean[] antiDiagonals) {
        if (row == n) {
            List<String> currentBoard = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] rowChars = new char[n];
                for (int j = 0; j < n; j++) {
                    rowChars[j] = (j == board[i]) ? 'Q' : '.';
                }
                currentBoard.add(new String(rowChars));
            }
            result.add(currentBoard);
            return;
        }

        for (int col = 0; col < n; col++) {
            int diag = row - col + (n - 1);
            int antiDiag = row + col;

            if (cols[col] || diagonals[diag] || antiDiagonals[antiDiag])
                continue;

            board[row] = (char) col;
            cols[col] = true;
            diagonals[diag] = true;
            antiDiagonals[antiDiag] = true;

            helper(row + 1, n, result, board, cols, diagonals, antiDiagonals);

            cols[col] = false;
            diagonals[diag] = false;
            antiDiagonals[antiDiag] = false;
        }
    }

    public static void main(String[] args) {
        Q51 solution = new Q51();
        int n = 4;
        List<List<String>> result = solution.solveNQueens(n);
        System.out.println("Distinct solutions for n = " + n + ":");
        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
