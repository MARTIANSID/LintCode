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
    public int countNodes(TreeNode root) {
        
            
            return solve(root);
    }
        public static int   solve(TreeNode root){
                
                if(root==null){
                        return 0;
                }
                
                int left=solve(root.left);
                int right=solve(root.right);
                
                return left+right+1;
                
                
        }
}