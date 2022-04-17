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
    TreeNode dummy=new TreeNode(-1);
    TreeNode prev=dummy;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        
        return dummy.right;
    }
    public void inorder(TreeNode root){
        
        if(root == null)return;
        
        inorder(root.left);
        prev.right=root;
        root.left=null;
        prev=root;
        inorder(root.right);
    }
}