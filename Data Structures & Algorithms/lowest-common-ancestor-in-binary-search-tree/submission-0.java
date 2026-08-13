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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while( current != null ){
          // If both p and q are greater, move to the right subtree
            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            // If both p and q are smaller, move to the left subtree
            else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            // We found the split point (the LCA)
            else {
                return current;
            }
        } 
        return null;  
    }
}
