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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return solve(root,low,high);
    }
    public TreeNode solve(TreeNode root,int low,int high){
        if(root == null)return null;
        
        int val=root.val;
        
        if(val < low){
            root.left=null;
            return root.right=solve(root.right,low,high);
        }else if(val > high){
            root.right=null;
            return root.left=solve(root.left,low,high);
        }else{
            root.left=solve(root.left,low,high);
            root.right=solve(root.right,low,high);
        }
        return root;
        
    }
}