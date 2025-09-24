//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//Write the code that will take a string and make this conversion given a number of rows: string convert(string s, int numRows);

//Example 1:
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"

//Example 2:
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I

//Example 3:
//Input: s = "A", numRows = 1
//Output: "A"

public class Q6 {
    public String convert(String s, int numRows) {

        if (s == null || s.length() == 0 || numRows <= 1)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < n; i++) {
            int row = i % cycleLen;
            if (row >= numRows) {
                row = cycleLen - row;
            }
            rows[row].append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
