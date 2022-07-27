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
    public void flatten(TreeNode root) {
        
        dfs(root);
    }
    public void dfs(TreeNode root){
        
        if(root==null)return;
        
        dfs(root.left);
        dfs(root.right);
        
        if(root.left!=null){
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.right=null;
            root.left=null;
            TreeNode tempLeft=left;
            while(tempLeft.right!=null){
                tempLeft=tempLeft.right;
            }
            tempLeft.right=right;
            root.right=left;
        }
    }
}