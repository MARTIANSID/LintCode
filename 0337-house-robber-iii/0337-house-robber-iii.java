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
    public int rob(TreeNode root) {
        
        int[] result = dfs(root);
        
        return Math.max(result[0],result[1]);
    }
    
    
    // 0th index -> var1
    // 1st index -> var2
    
    public int[] dfs(TreeNode root){
        
        if(root == null){
            return new int[2]; // [0,0]
        }
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int[] ans = new int[2];
        
        // setting var1
        
        ans[0] = root.val + left[1] + right[1];
        ans[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        
        return ans;
        
    } 
}