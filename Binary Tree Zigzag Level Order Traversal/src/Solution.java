import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.offer(root);
        int size, index = 0;
        while (!q.isEmpty()) {
            res.add(new ArrayList<>());
            size = q.size();
            TreeNode node;
            for (int i = 0; i < size; i++) {
                node = q.poll();
                res.get(index).add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            index++;
        }

        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}