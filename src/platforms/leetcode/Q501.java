
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructures.TreeNode;

public class Q501 {
    int maxCount = -1;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        helper(root, count);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() == maxCount)
                res.add(e.getKey());
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.getFirst();
            res.removeFirst();
        }
        return result;
    }

    private void helper(TreeNode root, Map<Integer, Integer> count) {
        if (root == null)
            return;
        count.put(root.val, count.getOrDefault(count, 0) + 1);
        maxCount = Math.max(maxCount, count.get(root.val));
        helper(root.left, count);
        helper(root.right, count);
    }
}
