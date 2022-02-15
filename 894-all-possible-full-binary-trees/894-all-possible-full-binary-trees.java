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
    public List<TreeNode> allPossibleFBT(int n) {
       
        if(n%2==0)return new ArrayList<>();
        
        return findAllPossibleTrees(n);
        
    }
    
    public List<TreeNode> findAllPossibleTrees(int n){
        
        if(n==1){
            List<TreeNode> temp=new ArrayList<>();
            TreeNode node=new TreeNode(0);
            temp.add(node);
            return temp;
        }
         
        List<TreeNode> ans=new ArrayList<>();
        for(int i=1;i<n;i+=2){
            List<TreeNode> left= findAllPossibleTrees(i);
            List<TreeNode> right=findAllPossibleTrees(n-i-1);

            for(int k=0;k<left.size();k++){
                
                
                for(int j=0;j<right.size();j++){
                TreeNode node=new TreeNode(0);
                node.left=left.get(k);
                    node.right=right.get(j);
                    ans.add(node);
                }
                
            }
                
            
         }    
        
        return ans;
    } 
}