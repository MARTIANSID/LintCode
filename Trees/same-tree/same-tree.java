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
    public boolean isSameTree(TreeNode p, TreeNode q) {
         return solve(p,q);
    }
    
    public boolean solve(TreeNode p,TreeNode q){
                
        if(p==null&&q!=null)return false;
        if(q==null&&p!=null)return false;
        if(p==null&&q==null)return true;
        
       boolean left= solve(p.left,q.left);
        if(!left)return false;
       boolean right= solve(p.right,q.right);
        if(!right)return false;
        
        if(p.val!=q.val)return false;
        
        return true;

    }
}