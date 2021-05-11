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
    int left=0;
    int right=0;
public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
int total=     dfs(root,x);
        
 int parent=  total-left-right-1;
        

        if(parent>left+right){
                return true;
        }else if(left>parent+right){
                return true;
        }else if(right>parent+left){
                return true;
        }
        
        return false;
        
}
    public int dfs(TreeNode root,int x){
            
            if(root==null)return 0;
            
          int l=  dfs(root.left,x);
          int r=  dfs(root.right,x);
            
            
            if(root.val==x){
            left=l;
            right=r;
            }
            
            
    return l+r+1;
            
            
    }
    
    
}