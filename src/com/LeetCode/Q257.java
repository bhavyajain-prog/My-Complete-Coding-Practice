// Given the root of a binary tree, return all root-to-leaf paths in any order.
// A leaf is a node with no children.

// Example 1:
// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]

// Example 2:
// Input: root = [1]
// Output: ["1"]

// Constraints:
// The number of nodes in the tree is in the range [1, 100].
// -100 <= Node.val <= 100

import java.util.ArrayList;
import java.util.List;
import DataStructures.TreeNode;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res, new StringBuilder());
        return res;
    }

    private void helper(TreeNode root, List<String> result, StringBuilder sb) {
        if (root == null) return;

        int len = sb.length();  // Save the current length of sb

        sb.append(root.val);

        if (root.left == null && root.right == null) {  // If it's a leaf node
            result.add(sb.toString());  // Add the path to result
        } else {
            sb.append("->");
            helper(root.left, result, sb);
            helper(root.right, result, sb);
        }

        sb.setLength(len);  // Reset sb to its original length after returning from recursion
    }
}
