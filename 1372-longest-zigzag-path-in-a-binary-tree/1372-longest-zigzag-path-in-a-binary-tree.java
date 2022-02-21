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
    int max=-(int)1e9;
    public int longestZigZag(TreeNode root) {
        solve(root,"both");
        
        return max;
    }
    
    public int solve(TreeNode root,String direction){
        if(root==null)return 0;
        
     int left=   solve(root.left,"left");
      int right=  solve(root.right,"right");
        
        max=Math.max(max,Math.max(left,right));
        
        // System.out.println(max+"bc");
        
        if(direction.equals("left")){
            return right+1;
        }else if(direction.equals("right")){
            return left+1;
        }else{
            return Math.max(left,right);
        }
        
    }
}