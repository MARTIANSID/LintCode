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
    public int sumRootToLeaf(TreeNode root) {
            return solve(root,"");   
    }
    
    public int solve(TreeNode root,String ans){
        
        
        if(root==null)return 0;
        
        int left=solve(root.left,ans+root.val);
        int right=solve(root.right,ans+root.val);
        
        if(root.left==null &&root .right ==null){
            return left+right+Integer.parseInt(ans+root.val,2);
        }
        return left+right;
    }
}