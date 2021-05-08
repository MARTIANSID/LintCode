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
    public String smallest="~";
public String smallestFromLeaf(TreeNode root) {
    
        
        solve(root,"");
        return new StringBuffer(smallest).reverse().toString();
}
    public void solve(TreeNode root,String path){
            if(root==null)return;
            
            if(root.left==null&&root.right==null){
                    String p=path+(char)(root.val+'a');
                    // String reverse = new StringBuffer(p).reverse().toString();
                    int i=p.length()-1;
                            
                    int j=smallest.length()-1;
                    int pp=0;
                   
                    while(i>=0&&j>=0){
                            if(p.charAt(i)<smallest.charAt(j)){
                                    smallest=p;
                                    pp=1;
                                    break;
                            }else if(p.charAt(i)>smallest.charAt(j)){
                                    pp=-1;
                                    break;
                            }
                            i--;
                            j--;
                    }
                    
                    if(pp==0){
                            smallest=p.length()<smallest.length()?p:smallest;
                    }
                    
                    
                    
            
            }
            
            
            solve(root.left,path+(char)(root.val+'a')+"");
            solve(root.right,path+(char)(root.val+'a')+"");
            
    }
}