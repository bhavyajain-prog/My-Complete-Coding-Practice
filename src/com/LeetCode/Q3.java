//Given a string s, find the length of the longest substring without repeating characters.

//Example 1:
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.

//Example 2:
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.

//Example 3:
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashMap;

public class Q3 {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();

		int start = 0;
		int maxLength = 0;
		for (int end = 0; end < s.length(); end++) {
			char curr = s.charAt(end);
			if (map.containsKey(curr))
				start = Math.max(start, map.get(curr) + 1);
			map.put(curr, end);
			int length = end - start + 1;
			maxLength = Math.max(maxLength, length);
		}
		return maxLength;
	}
}
