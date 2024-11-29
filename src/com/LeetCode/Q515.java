// Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

// Example 1:
// Input: root = [1,3,2,5,3,null,9]
// Output: [1,3,9]

// Example 2:
// Input: root = [1,2,3]
// Output: [1,3]

// Constraints:
// The number of nodes in the tree will be in the range [0, 104].
// -231 <= Node.val <= 231 - 1

import java.util.ArrayList;
import java.util.List;

import DataStructures.TreeNode;

public class Q515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return helper(res, root, 0);
    }

    private List<Integer> helper(List<Integer> res, TreeNode root, int level) {
        if (root == null) {
            return res;
        }
        if (res.size() == level) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
        return res;
    }
}
