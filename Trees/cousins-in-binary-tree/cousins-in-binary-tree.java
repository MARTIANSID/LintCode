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
    
    class pair{
        int parent;
        int level;
        pair(int parent,int level){
            this.parent=parent;
            this.level=level;
        }
    }
    
    HashMap<Integer,pair> map=new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
     
        solve(root,x,y,-1,0);
        
      pair p1=  map.get(x);
        pair p2=map.get(y);
        
        if(p1.parent!=p2.parent&&p1.level==p2.level)return true;
        
        return false;
        
    }
    
    public void solve(TreeNode root,int x,int y,int parent,int level){
            if(root==null)
            {
                return;
            }
        
        
        
       solve(root.left,x,y,root.val,level+1);
        solve(root.right,x,y,root.val,level+1);
        
        if(root.val==x){ 
            map.put(x,new pair(parent,level));
        }
        
        if(root.val==y){
            map.put(y,new pair(parent,level));
        }
        
        

    }
     
    }
