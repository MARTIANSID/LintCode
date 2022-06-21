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

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }

    public TreeNode dfs(TreeNode root, int sum, int limit) {
        if (root == null) return null;
        
        if(root.left == null && root.right == null && (sum+root.val)<limit)return null;
        else if(root.left == null && root.right == null)return root;
        
        TreeNode left = dfs(root.left, sum + root.val, limit);
        TreeNode right = dfs(root.right, sum + root.val, limit);
        
        if(left == null && right == null)return null;
        
        root.left=left;
        root.right=right;

        return root;
    }
}
