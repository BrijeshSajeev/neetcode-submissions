/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean validate(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        // The current node must strictly fit within its inherited boundaries
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Left child must be smaller than current root.val (updates the max   bound)
        // Right child must be greater than current root.val (updates the min bound)
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
