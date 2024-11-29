// Given a string containing just the characters '(' and ')', return the length 
// of the longest valid (well-formed) parentheses substring.

// Example 1:
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".

// Example 2:
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".

// Example 3:
// Input: s = ""
// Output: 0

// Constraints:
// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.

import java.util.Stack;

public class Q32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q32 q32 = new Q32();
        String s = "((()"; // 2
        int result = q32.longestValidParentheses(s);
        System.out.println(s + " : " + result);
        s = ")()())"; // 4
        result = q32.longestValidParentheses(s);
        System.out.println(s + " : " + result);
        s = ""; // 0
        result = q32.longestValidParentheses(s);
        System.out.println(s + " : " + result);
    }
}
