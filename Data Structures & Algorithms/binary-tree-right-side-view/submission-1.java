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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new ArrayList<>();

        if(root == null){
            return right;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        while(!qu.isEmpty()){
            int levelSize = qu.size();

            for(int i=0;i<levelSize; i++){
                TreeNode curr = qu.poll();

                if(i==0){
                    right.add(curr.val);
                }

                if(curr.right != null){
                    qu.add(curr.right);
                }

                if(curr.left != null){
                    qu.add(curr.left);
                }
            }
        }

        return right;
    }
}
