//Given a string s, return the longest palindromic substring in s.

//Example 1:
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.

//Example 2:
//Input: s = "cbbd"
//Output: "bb"

public class Q5 {
	int maxLength = 0;
	int start;
	public String longestPalindrome(String s) {

		for (int i = 0; i < s.length(); i++) {
			lengthOfPalindrome(s, i, i + 1);
			lengthOfPalindrome(s, i, i);
		}
		return s.substring(start, start + maxLength);
	}

	private void lengthOfPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		left++;
		right--;

		int length = right - left + 1;

		if (length > maxLength) {
			maxLength = length;
			start = left;
		}
	}
}
