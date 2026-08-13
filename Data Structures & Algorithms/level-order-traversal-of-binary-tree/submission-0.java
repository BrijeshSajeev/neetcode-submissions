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
    public List<List<Integer>> levelOrder(TreeNode root) {  
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);

        while(!qu.isEmpty()){
            int levelSize = qu.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i=0;i<levelSize;i++){
                TreeNode currNode = qu.poll();
                currentLevel.add(currNode.val);

                if(currNode.left !=null){
                    qu.add(currNode.left);
                }

                if(currNode.right !=null){
                    qu.add(currNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}
