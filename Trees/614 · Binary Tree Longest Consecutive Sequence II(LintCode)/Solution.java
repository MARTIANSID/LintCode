/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
     int max=0;
    public int longestConsecutive2(TreeNode root) {
      int[] a=  solve(root);
        
        return max;
    }


    public int[] solve(TreeNode root){
         if(root==null){
             int[] a=new int[2];
             a[0]=1;
            a[1]=1;
            return a;
         }
        int[] left= solve(root.left);
       int[] right=  solve(root.right);
       int currDecl=1;
       int currIncl=1;
       int currDecr=1;
       int currIncr=1;

       if(root.left!=null){
           if(root.left.val==root.val+1){
               currIncl=left[0]+1;
           }
           if(root.left.val==root.val-1){
               currDecl=left[1]+1;
           }
           
       }

       if(root.right!=null){

           if(root.right.val==root.val+1){
               currIncr=right[0]+1;
           }
           if(root.right.val==root.val-1){
               currDecr=right[1]+1;
           }
       }
    max=Math.max(max,Math.max(currDecr+currIncl-1,currDecl+currIncr-1));
    int[] ans=new int[2];
    ans[0]=Math.max(currIncr,currIncl);
    ans[1]=Math.max(currDecr,currDecl);

    return ans;
       




    }
}