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
    int max=0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        
        return max==0?0:max-1;
    }
    public int dfs(TreeNode root){
        
        if(root==null)return 0;
        
       int left= dfs(root.left);
       int right= dfs(root.right);
        
        int l=0,r=0;
        
        if(root.left !=null && root.left.val == root.val){
            l=left;
        }
        
        if(root.right !=null && root.right.val == root.val){
            r=right;
        }
        max=Math.max(max,(l+r+1));
        
        return Math.max(l,r)+1;
    }
}