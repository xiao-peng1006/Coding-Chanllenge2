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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        Collections.reverse(res);
        return res;
    }

    public void helper(TreeNode node, List<List<Integer>> res, int i) {
        if (node == null) {
            return;
        }

        if (res.size() == i) {
            res.add(new ArrayList<>());
        }
        res.get(i).add(node.val);
        helper(node.left, res, i + 1);
        helper(node.right, res, i + 1);
    }
}