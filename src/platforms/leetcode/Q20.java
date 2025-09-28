// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

// Example 1:
// Input: s = "()"
// Output: true

// Example 2:
// Input: s = "()[]{}"
// Output: true

// Example 3:
// Input: s = "(]"
// Output: false

public class Q20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        char[] stack = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (top > -1 && ((c == ')' && stack[top] == '(') || (c == '}' && stack[top] == '{')
                    || (c == ']' && stack[top] == '[')))
                top--;
            else if (c == '(' || c == '{' || c == '[')
                stack[++top] = c;
            else
                return false;
        }
        return top == -1;
    }
}
