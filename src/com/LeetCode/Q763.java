// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
// Return a list of integers representing the size of these parts.

// Example 1:
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

// Example 2:
// Input: s = "eccbbbbdec"
// Output: [10]

// Constraints:
// 1 <= s.length <= 500
// s consists of lowercase English letters.

import java.util.ArrayList;
import java.util.List;

public class Q763 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0, l = 0; i < n; i += l) {
            res.add(l = partitionLabel(chars, i));
        }
        return res;
    }
    public int partitionLabel(char[] chars, int beg) {
        boolean[] set = new boolean['z' - 'a' + 1];
        set[chars[beg] - 'a'] = true;
        int end = beg + 1;
        for (int i = end; i < chars.length; i++) {
            if (set[chars[i] - 'a']) {
                for (int j = end; j < i; j++) {
                    set[chars[j] - 'a'] = true;
                }
                end = i + 1;
            }
        }
        return end - beg;
    }

    public static void main(String[] args) {
        Q763 solution = new Q763();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> partitions = solution.partitionLabels(s);
        System.out.println(partitions);
    }
}