// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [1]
// Output: [1]

// Constraints:\
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

import DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q144 {
    static List<Integer> node = new ArrayList<Integer>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return node;
        }
        preOrder(root);
        return node;
    }

    private static void preOrder(TreeNode root) {
        if (root == null)
            return;
        node.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(preorderTraversal(root));
    }
}
