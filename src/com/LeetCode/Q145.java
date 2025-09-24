// Given the root of a binary tree, return the postorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [1]
// Output: [1]

// Constraints:
// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

import java.util.ArrayList;
import java.util.List;

import DataStructures.TreeNode;

public class Q145 {
    List<Integer> nodes = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            nodes.add(root.val);
        }
        return nodes;
    }
}
