// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = ""
// Output: []

// Example 3:
// Input: digits = "2"
// Output: ["a","b","c"] 

// Constraints:
// 0 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q17 {
    private static final HashMap<Integer, String> digit = new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        if (digits.length() == 0)
            return resultList;

        digit.put(2, "abc");
        digit.put(3, "def");
        digit.put(4, "ghi");
        digit.put(5, "jkl");
        digit.put(6, "mno");
        digit.put(7, "pqrs");
        digit.put(8, "tuv");
        digit.put(9, "wxyz");

        StringBuilder sb = new StringBuilder();
        backtrack(digits, 0, sb, resultList);
        return resultList;
    }

    private static void backtrack(String digits, int i, StringBuilder sb, List<String> resultList) {
        if (i >= digits.length()) {
            resultList.add(sb.toString());
            sb = new StringBuilder();
            return;
        }
        String letters = digit.get(digits.charAt(i) - '0');
        for (int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));
            backtrack(digits, i + 1, sb, resultList);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
