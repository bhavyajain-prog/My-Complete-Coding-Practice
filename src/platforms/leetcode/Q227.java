// Given a string s which represents an expression, evaluate this expression and return its value. 
// The integer division should truncate toward zero.
// You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
// Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

// Example 1:
// Input: s = "3+2*2"
// Output: 7

// Example 2:
// Input: s = " 3/2 "
// Output: 1

// Example 3:
// Input: s = " 3+5 / 2 "
// Output: 5

// Constraints:
// 1 <= s.length <= 3 * 105
// s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
// s represents a valid expression.
// All the integers in the expression are non-negative integers in the range [0, 231 - 1].
// The answer is guaranteed to fit in a 32-bit integer.

public class Q227 {
    public int calculate(String s) {
        if (s == null || s.trim().length() == 0)
            return 0;
        int len = s.length();
        if (len == 0)
            return 0;
        int curr = 0;
        int last = 0;
        int res = 0;
        char op = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = curr * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                if (op == '+') {
                    res += last;
                    last = curr;
                } else if (op == '-') {
                    res += last;
                    last = -curr;
                } else if (op == '*') {
                    last *= curr;
                } else if (op == '/') {
                    last /= curr;
                }
                op = c;
                curr = 0;
            }
        }
        res += last;
        return res;
    }
}