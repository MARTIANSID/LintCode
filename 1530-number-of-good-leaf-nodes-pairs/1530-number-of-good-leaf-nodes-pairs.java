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
    int ans=0;
    public int countPairs(TreeNode root, int distance) {
        
        
        solve(root,distance);
        
        return ans;
    }
    public List<Integer> solve(TreeNode root,int distance){
        if(root==null){
            return new ArrayList<>();
        }
        
        List<Integer> current=new ArrayList<>();
        
        if(root.left==null&&root.right==null){
            current.add(1);
            return current;
        }
        
      List<Integer> left=  solve(root.left,distance);
      List<Integer> right=  solve(root.right,distance);
        
      for(int e:left){
          for(int ele:right){
              if((e+ele)<=distance){
                  ans++;
              }
          }
      }  
        
        left.addAll(right);
        
        for(int i=0;i<left.size();i++){
            left.set(i,left.get(i)+1);
        }
        
        return left;
        
    
        
        
    }
}