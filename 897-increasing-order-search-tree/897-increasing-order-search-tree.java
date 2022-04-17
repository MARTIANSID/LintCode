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
    TreeNode r=dummy;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        
        return r.right;
    }
    public void inorder(TreeNode root){
        
        if(root == null)return;
        
        inorder(root.left);
        dummy.right=new TreeNode(root.val);
        dummy=dummy.right;
        
        inorder(root.right);
    }
}